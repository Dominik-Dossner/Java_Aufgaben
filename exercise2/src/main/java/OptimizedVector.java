public class OptimizedVector extends Vector {
    private Object[] elements;
    private int size;
    
    public OptimizedVector() {
        super();
    }

    @Override
    public boolean add(Object obj) {
        return super.add(obj);
    }

    @Override
    public void clear() {
        size = 0;
    }
}
