package org.capcaval.tools.pair;


public class PairFactoryImpl implements PairFactory{

	@Override
	public <T1, T2> Pair<T1, T2> newPair(T1 firstItem, T2 secondItem) {
		return new PairImpl<T1,T2>(firstItem, secondItem);
	}

}
