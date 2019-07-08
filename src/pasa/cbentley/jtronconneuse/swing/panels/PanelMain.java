package pasa.cbentley.jtronconneuse.swing.panels;

import java.awt.BorderLayout;

import pasa.cbentley.jtronconneuse.common.JSawLogEntry;
import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;
import pasa.cbentley.jtronconneuse.swing.interfaces.ISwingTronconneuse;

public class PanelMain extends PanelTronco implements ISwingTronconneuse {

   private TabsTronco tabsTronco;
   private PanelTabController tabsController;

   public PanelMain(TroncoSwingCtx tsc) {
      super(tsc);
      
      this.setLayout(new BorderLayout());
      
      tabsTronco = new TabsTronco(tsc);
      tabsController = new PanelTabController(tsc);
      tabsController.setTabsTronco(tabsTronco);
      
      this.add(tabsController, BorderLayout.NORTH);
      this.add(tabsTronco, BorderLayout.CENTER);
   }

   public void initCheck() {
      
      tabsTronco.initCheck();
      
      //manually select a tab for initialization
      TroncoTabAbstract first = tabsTronco.getFirst();
      first.initCheck();
      tabsTronco.setSelected(first);      
   }

   public void newLogArrivedTronconneIt(JSawLogEntry log) {
      tabsTronco.newLogArrivedTronconneIt(log);
   }

}
