public class OptimizedList extends List {
    public OptimizedList() {
        super();
    }

    @Override
    public boolean add(Object ojc) {
        return super.add(ojc);
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }
}
