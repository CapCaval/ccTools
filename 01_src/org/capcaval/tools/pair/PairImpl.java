package org.capcaval.tools.pair;

class PairImpl<T1, T2> implements Pair<T1, T2>{
	private final T1 firstItem;
	private final T2 secondItem;

	public PairImpl(T1 firstItem, T2 secondItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
	}

	public static <T1, T2> PairImpl<T1, T2> createPair(T1 firstItem, T2 secondItem) {
		return new PairImpl<T1, T2>(firstItem, secondItem);
	}

	@Override
	public T1 firstItem() {
		return firstItem;
	}
	@Override
	public T2 secondItem() {
		return secondItem;
	}
}