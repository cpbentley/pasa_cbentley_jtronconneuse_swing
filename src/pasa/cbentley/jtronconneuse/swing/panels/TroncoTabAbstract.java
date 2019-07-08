package pasa.cbentley.jtronconneuse.swing.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.ITechLvl;
import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;
import pasa.cbentley.jtronconneuse.swing.interfaces.ISwingTronconneuse;
import pasa.cbentley.swing.imytab.AbstractMyTab;
import pasa.cbentley.swing.widgets.b.BLabel;

/**
 * A message with a GIF playing with how to use the daemon
 * @author Charles Bentley
 *
 */
public abstract class TroncoTabAbstract extends AbstractMyTab implements ISwingTronconneuse {

   /**
    * 
    */
   private static final long   serialVersionUID = 8194278974893842214L;

   private String              titleKey;

   protected TroncoSwingCtx    tsc;

   public TroncoTabAbstract(TroncoSwingCtx tsc, String id) {
      super(tsc.getSwingCtx(), id);
      this.tsc = tsc;

   }

   public void tabLostFocus() {
   }


   public void tabGainFocus() {
   }

   public void disposeTab() {
      //#debug
      toDLog().pFlow("", this, TroncoTabAbstract.class, "disposeTab", ITechLvl.LVL_05_FINE, true);

   }

   public void initTab() {
      this.setLayout(new BorderLayout());

      //panel without sorting options
      JPanel north = new JPanel();


      this.add(north, BorderLayout.NORTH);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "AbstractTroncoTab");
      super.toString(dc.sup());
      //print 
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "AbstractTroncoTab");
      super.toString(dc.sup1Line());
   }
   //#enddebug

}
