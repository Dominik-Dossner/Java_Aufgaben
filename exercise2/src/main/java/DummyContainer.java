import java.util.ArrayList;

public class DummyContainer implements Container {
	private java.util.List<Object> arrayList = new ArrayList<>();
	
	@Override
	public boolean add(Object o) {
		return arrayList.add(o);
	}

	@Override
	public Object get(int i) {
		return arrayList.get(i);
	}

	@Override
	public int size() {
		return arrayList.size();
	}

	@Override
	public boolean remove(Object o) {
		return arrayList.remove(o);
	}
}
