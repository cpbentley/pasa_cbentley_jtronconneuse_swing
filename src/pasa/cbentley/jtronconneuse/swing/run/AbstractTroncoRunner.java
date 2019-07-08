package pasa.cbentley.jtronconneuse.swing.run;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.prefs.Preferences;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.interfaces.IPrefs;
import pasa.cbentley.core.src4.logging.BaseDLogger;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IConfig;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.core.src4.logging.ITechConfig;
import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.jtronconneuse.ctx.JTroncoCtx;
import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;
import pasa.cbentley.swing.SwingPrefs;
import pasa.cbentley.swing.actions.IExitable;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.window.CBentleyFrame;

public abstract class AbstractTroncoRunner implements IExitable, IStringable {

   protected CBentleyFrame       frame;


   protected final SwingCtx      sc;

   protected final UCtx          uc;


   protected final TroncoSwingCtx tsc;


   protected final JTroncoCtx jtc;

   public AbstractTroncoRunner(TroncoSwingCtx tsc) {
      this.tsc = tsc;
      this.jtc = tsc.getJTroncoCtx();
      this.sc = tsc.getSwingCtx();
      this.uc = sc.getUCtx();
   }

   public AbstractTroncoRunner() {
      uc = new UCtx();
      sc = new SwingCtx(uc);
      jtc = new JTroncoCtx(uc);
      tsc  = new TroncoSwingCtx(jtc, sc);
   }

   /**
    * setup the logger at. sub class may override.
    */
   protected void setupLogger() {
      BaseDLogger loggerFirst = (BaseDLogger) uc.toDLog();
      IConfig config = loggerFirst.getDefault().getConfig();
      config.setLevelGlobal(ITechLvl.LVL_03_FINEST);
      config.setFlagPrint(ITechConfig.MASTER_FLAG_02_OPEN_ALL_PRINT, true);
   }

   public void cmdExit() {
      //finish current thread
      
      //#debug
      toDLog().pFlow("", this, AbstractTroncoRunner.class, "cmdExit", LVL_05_FINE, true);
      
      System.exit(0);
   }

   public void initUIThreadOutside() {
      setupLogger();
      
      List<String> list = Arrays.asList("i18nSwing", "i18nTroncoSwing");
      sc.setBundleList(list);
      Class clas = this.getClass();
      Preferences preferences = Preferences.userNodeForPackage(clas);
      IPrefs iprefs = new SwingPrefs(sc, preferences);
      sc.setPrefs(iprefs);

      //TODO cannot run without prefs.. 
      String language = "en";
      String country = "US";
      Locale currentLocale = new Locale(language, country);
      sc.setLocale(currentLocale);
      
      //#debug
      toDLog().pFlow("language="+language + "country="+country, this, AbstractTroncoRunner.class, "initUIThreadOutside", LVL_05_FINE, true);
      
   }
   
   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "AbstractTroncoRunner");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "AbstractTroncoRunner");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return uc;
   }

   //#enddebug
   

}
