package pasa.cbentley.jtronconneuse.swing.panels;

import pasa.cbentley.jtronconneuse.common.JSawLogEntry;
import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;
import pasa.cbentley.jtronconneuse.swing.interfaces.ISwingTronconneuse;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;

public class TabsTronco extends TabbedBentleyPanel implements ISwingTronconneuse {

   protected TroncoSwingCtx  tsc;

   private TroncoTabAbstract tab1;

   private TroncoTabAbstract tab2;

   private TroncoTabAbstract tab3;

   public TabsTronco(TroncoSwingCtx tsc) {
      super(tsc.getSwingCtx(), "tabs_tronco");
      this.tsc = tsc;
   }

   public void disposeTab() {

   }

   public void initTabs() {
      tab1 = new TroncoTabTextPane(tsc, "tab_1");
      tab2 = new TroncoTabTextPane(tsc, "tab_2");

      this.addMyTab(tab1);
      this.addMyTab(tab2);
   }

   public TroncoTabAbstract getFirst() {
      return tab1;
   }

   public void newLogArrivedTronconneIt(JSawLogEntry log) {

      tab1.newLogArrivedTronconneIt(log);
      tab2.newLogArrivedTronconneIt(log);
   }
}
