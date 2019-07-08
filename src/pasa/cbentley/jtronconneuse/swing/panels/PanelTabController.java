package pasa.cbentley.jtronconneuse.swing.panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;
import pasa.cbentley.swing.widgets.b.BButton;

public class PanelTabController extends PanelTronco implements ActionListener {

   private TabsTronco         tabsTronco;

   private BButton            butAddTab;


   public PanelTabController(TroncoSwingCtx tsc) {
      super(tsc);

      this.setLayout(new FlowLayout());

      butAddTab = new BButton(sc, this, "but.addtronctab");

      this.add(butAddTab);
   }

   public void actionPerformed(ActionEvent e) {
      Object src = e.getSource();
      if(src == butAddTab) {
         cmdAddTab();
      }
   }

   private void cmdAddTab() {
      // TODO Auto-generated method stub
      
   }

   public TabsTronco getTabsTronco() {
      return tabsTronco;
   }

   public void setTabsTronco(TabsTronco tabsTronco) {
      this.tabsTronco = tabsTronco;
   }

}
