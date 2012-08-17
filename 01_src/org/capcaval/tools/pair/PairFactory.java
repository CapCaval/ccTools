package org.capcaval.tools.pair;

public interface PairFactory {
	
	public static PairFactory factory = new PairFactoryImpl();
	
	public <T1, T2> Pair <T1, T2> newPair(T1 firstItem, T2 secondItem); 
	
}
