package pasa.cbentley.jtronconneuse.swing.panels;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.jtronconneuse.swing.ctx.TroncoSwingCtx;
import pasa.cbentley.swing.widgets.b.BPanel;

public class PanelTronco extends BPanel implements IStringable {

   /**
    * 
    */
   private static final long      serialVersionUID = 3330822410415807175L;

   protected final TroncoSwingCtx tsc;

   public PanelTronco(TroncoSwingCtx tsc) {
      super(tsc.getSwingCtx());
      this.tsc = tsc;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "PanelTronco");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "PanelTronco");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
