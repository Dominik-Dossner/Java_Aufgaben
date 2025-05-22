public abstract class AbstractContainer implements Container {
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Container)) return false;

        Container second = (Container) obj;
        if(this.size() != second.size()) return false;

        for (int i = 0; i < size(); i++) {
            Object obj1 = this.get(i);
            Object obj2 = second.get(i);


            if (obj1 == null) {
                if (obj2 != null) return false;
            } else if (!obj1.equals(obj2)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            result.append(get(i));
            if(i < size() - 1) {result.append(",");}
        }

        return result.append("]").toString();
    }

}
