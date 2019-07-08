package pasa.cbentley.jtronconneuse.swing.ctx;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.jtronconneuse.ctx.JTroncoCtx;
import pasa.cbentley.swing.ctx.SwingCtx;

public class TroncoSwingCtx extends ACtx {

   protected final JTroncoCtx jtc;

   protected final SwingCtx   sc;

   public TroncoSwingCtx(JTroncoCtx jtc, SwingCtx sc) {
      super(sc.getUCtx());
      this.jtc = jtc;
      this.sc = sc;

   }

   public SwingCtx getSwingCtx() {
      return sc;
   }

   public JTroncoCtx getJTroncoCtx() {
      return jtc;
   }
}
