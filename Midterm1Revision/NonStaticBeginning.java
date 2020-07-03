public class NonStaticBeginning {

    public void m1(Object var1) {
        System.out.println("m1 --> NSB (Object)");
    }

    public void m1(TR var1) {
        System.out.println("m1 --> NSB (T)");
    }

    public static class T extends NonStaticBeginning {

        @Override
        public void m1(Object var1) {
            System.out.println("m1 --> T (Object)");
            class inside {
                public int x = 100;
                public void pp() {
                    System.out.println(this.x);
                }
            }
            inside ii = new inside();
            ii.pp();
        }

        public void m1(TLR var1) {
            System.out.println("m1 --> T (TLR)");
        }

        public void m1(T var1) {
            System.out.println("m1 --> T (T)");
        }

        public void m1(TL var1) {
            System.out.println("m1 --> T (TL)");
        }

    }

    public static class TL extends T {

        @Override
        public void m1(Object var1) {
            System.out.println("m1 --> TL (Object)");
        }
        @Override
        public void m1(T var1) {
            System.out.println("m1 --> TL (T)");
        }
        @Override
        public void m1(TL var1) {
            System.out.println("m1 --> TL (TL)");
        }

    }

    public class TR extends T {

        @Override
        public void m1(Object var1) {
            System.out.println("m1 --> TR (Object)");
        }

//        public void m1(T var1) {
//            System.out.println("m1 --> TR (T)");
//        }

        @Override
        public void m1(TL var1) {
            System.out.println("m1 --> TR (TL)");
        }

    }

    public static class TLL extends TL {

        @Override
        public void m1(Object var1) {
            System.out.println("m1 --> TLL (Object)");
        }

        @Override
        public void m1(T var1) {
            System.out.println("m1 --> TLL (T)");
        }

        @Override
        public void m1(TL var1) {
            System.out.println("m1 --> TLL (TL)");
        }

        public void m1(TLL var1) {
            System.out.println("m1 --> TLL (TLL)");
        }



    }

    public class TLR extends TL {

        @Override
        public void m1(Object var1) {
            System.out.println("m1 --> TLR (Object)");
        }

        @Override
        public void m1(T var1) {
            System.out.println("m1 --> TLR (T)");
        }

//        public void m1(TL var1) {
//            System.out.println("m1 --> TLR (TL)");
//        }

        public void m1(TLR var1) {
            System.out.println("m1 --> TLR (TLR)");
        }

        public class TLRR extends TLR {

            @Override
            public void m1(Object var1) {
                System.out.println("m1 --> TLRR (Object)");
            }

            public void m1(T var1) {
                System.out.println("m1 --> TLRR (T)");
            }

            public void m1(TL var1) {
                System.out.println("m1 --> TLRR (TL)");
            }

        }

    }

    public static void main(String[] args) {
        NonStaticBeginning NSB = new NonStaticBeginning();
        Object o_t = new T();
        T t_t = new T();
        T t_tl = new TL();
        T t_tr = NSB.new TR();
        TR tr_tr = NSB.new TR();
        T t_tll = new TLL();
        T t_tlr = NSB.new TLR();
        TLR tlr = NSB.new TLR();
        T t_tlrr = tlr.new TLRR();
        TL tl_tl = new TL();
        TL tl_tll = new TLL();
        TL tl_tlr = NSB.new TLR();
        TLL tll_tll = new TLL();

//        t_t.m1(o_t); // m1 --> T (Object) ... 100
//        t_t.m1(t_t); // m1 --> T (T)
//        t_t.m1(t_tl); // m1 --> T (T);
//        t_t.m1(tl_tl); // m1 --> T (TL)
//        t_tl.m1(t_t); // m1 --> TL (T)
//        t_tl.m1(t_tl); // m1 --> TL (T)
//        t_tl.m1(tl_tl); // m1 --> TL (TL)
//        t_tl.m1(t_tr); // m1 --> TL (T)
//        t_tl.m1(tr_tr); // m1 --> TL (T)
//        t_tl.m1(tll_tll); // m1 --> TL (TL)
//        t_tl.m1(tlr); // m1 --> T (TLR)
//        t_tl.m1(tll_tll); // m1 --> TL (TL)
//        tl_tll.m1(t_t); // m1 --> TLL (T)
//        t_tlr.m1(NSB); // m1 --> TLR (Object)
//        tr_tr.m1(tr_tr); // m1 --> NSB (T)
//        tl_tlr.m1(tr_tr); // m1 --> NSB (T)
//        tl_tlr.m1(t_tlr); // m1 --> TLR (T)
//        tl_tlr.m1(tlr); // m1 --> TLR (TLR)



//        T JUNK1 = ((TLR) t_tlr).new TLRR();
//        TLR tt = NSB.new TLR();
//        TLR.TLRR ttt = tt.new TLRR();
//        T t_t = new T();
//        ttt.m1(t_t); // m1 --> TLRR (T)
//        t_t.m1(t_t); // m1 --> T (T)

    }
}
