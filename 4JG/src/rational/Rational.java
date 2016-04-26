package rational;

import java.math.BigInteger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Rational implements Comparable<Rational> {

	// Fields
	private BigInteger numerator;
	private BigInteger denominator;

	// ***** Constructors
	// ****************************************************************

	/**
	 * Constructor with two BigInteger
	 * @param n numerator
	 * @param d denominator
	 */
	public Rational(BigInteger n, BigInteger d) {
		int comp = d.compareTo(BigInteger.ZERO);
		if (comp == 0) {
			throw new RuntimeException("Rational Error: Cannot construct Rational with zero denominator");
		}
		this.numerator=n;
		this.denominator=d;
		this.normalize();
		this.shorten();
	}
	/**
	 * Constructor with two long
	 * @param n numerator
	 * @param d denominator
	 */
	public Rational(long n, long d) {
		this(BigInteger.valueOf(n), BigInteger.valueOf(d));
	}

	/**
	 * Constructor with one BigInteger
	 * @param n numerator
	 */
	public Rational(BigInteger n){
		this(n, BigInteger.ONE);
	}
	
	/**
	 * Constructor with one long
	 * @param n numerator
	 */
	public Rational(long n){
		this(BigInteger.valueOf(n), BigInteger.ONE);
	}
	
	
	/**
	 * Default Constructor
	 * 
	 */
	public Rational(){
		this(BigInteger.ZERO);
	}
	
	
	// ***** Access Functions
	// ***********************************************************

	/**
	 * is the current Rational equal to ZERO 
	 * @return isZero
	 */
	public boolean isZero() {
		return this.numerator.compareTo(BigInteger.ZERO) == 0;
	}

	/**
	 * is the current Rational greater than ZERO
	 * @return isPositive
	 */
	public boolean isPositive() {
		this.normalize();
		return this.numerator.compareTo(BigInteger.ZERO) > 0;
	}

	/**
	 * is the current RAtional lower than ZERO
	 * @return isNegative
	 */
	public boolean isNegative() {
		this.normalize();
		return this.numerator.compareTo(BigInteger.ZERO) < 0;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rational)) return false;
		Rational r= (Rational) obj;
		return this.compareTo(r)==0;
	}
	/**
	 * compareTo to the second Rational
	 * @param q the second Rational
	 * @return 1 for greater than, 0 for equal and -1 for lower than
	 */
	public int compareTo(Rational q) {
		BigInteger a = this.numerator;
		BigInteger b = this.denominator;
		BigInteger c = q.numerator;
		BigInteger d = q.denominator;
		BigInteger e = (a.multiply(d)).subtract(b.multiply(c));
		return e.compareTo(BigInteger.ZERO);
	}

	// ***** Manipulation Procedures
	// ****************************************************
	/**
	 * normalize the current Rational
	 */
	public void normalize() {
		if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
			this.denominator = this.denominator.abs();
			this.numerator = this.numerator.negate();
		}
	}

	/**
	 * negate the current Rational
	 */
	public void negate() {
		this.numerator = this.numerator.negate();
		this.normalize();
	}

	/**
	 * invert the current Rational
	 */
	public void invert() {
		BigInteger n = this.numerator;
		BigInteger d = this.denominator;
		int comp = n.compareTo(BigInteger.ZERO);
		if (comp == 0)
			throw new RuntimeException("Rational Error: Cannot invert zero");
		this.denominator = n;
		this.numerator = d;
		this.normalize();
	}

	/**
	 * add a Rational to our current Rational
	 * @param q second Rational
	 * @return new Rational
	 */
	public Rational add(Rational q) {
		Rational p = this.copy();
		return Rational.add(p,q);
	}

	/**
	 * add two Rational and create a new one with the sum 
	 * @param p first Rational
	 * @param q second Rational
	 * @return new Rational
	 */
	public static Rational add(Rational p, Rational q) {
		BigInteger a = p.numerator;
		BigInteger b = p.denominator;
		BigInteger c = q.numerator;
		BigInteger d = q.denominator;
		BigInteger numerator = (a.multiply(d)).add(b.multiply(c));
		BigInteger denominator = b.multiply(d);
		Rational r =new Rational(numerator, denominator);
		r.normalize();
		r.shorten();
		return r;
	}

	/**
	 * subtract from our current Rational the given one
	 * @param q second Rational
	 * @return new Rational
	 */
	public Rational sub(Rational q) {
		Rational p = this.copy();
		return Rational.sub(p,q);
	}

	/**
	 * subtract from our current Rational and create a new one with the difference 
	 * @param p first Rational
	 * @param q second Rational
	 * @return new Rational
	 */
	public static Rational sub(Rational p, Rational q) {
		Rational s = q.copy();
		s.negate();
		return Rational.add(p, s);
	}

	/**
	 * multiply the current Rational with the given one and create a new one with the product 
	 * @param q second Rational
	 * @return new Rational
	 */
	public Rational mult(Rational q) {
		Rational p = this.copy();
		return Rational.mult(p, q);
	}

	/**
	 * multiply two Rational and create a new one with the product 
	 * @param p first Rational
	 * @param q second Rational
	 * @return new Rational
	 */
	public static Rational mult(Rational p,Rational q) {
		BigInteger a = p.numerator;
		BigInteger b = p.denominator;
		BigInteger c = q.numerator;
		BigInteger d = q.denominator;
		BigInteger gcd_ad = a.gcd(d);
		BigInteger gcd_bc = b.gcd(c);
		BigInteger numerator = (a.divide(gcd_ad)).multiply(c.divide(gcd_bc));
		BigInteger denominator = (b.divide(gcd_bc)).multiply(d.divide(gcd_ad));
		Rational r= new Rational(numerator, denominator);
		r.normalize();
		return r;
	}

	/**
	 * divide the current Rational by the given one and create a new one with the quotient 
	 * @param q second Rational
	 * @return new Rational
	 */
	public Rational div(Rational q) {
		Rational p = this.copy();
		return Rational.div(p, q);
	}

	/**
	 * divide the first Rational by the second one and create a new one with the quotient
	 * @param p first Rational 
	 * @param q second Rational
	 * @return new Rational
	 */
	public static Rational div(Rational p,Rational q) {
		Rational s=q.copy();
		s.invert();
		return Rational.mult(p, s);
	}

	/**
	 * make a deep copy of the current Rational
	 * @return new Rational
	 */
	public Rational copy() {
		return Rational.valueOf(this.numerator, this.denominator);
	}

	// *****                  Other Functions                 *****
	// ************************************************************
	
	/**
	 * @return the numerator
	 */
	public BigInteger getNumerator() {
		return numerator;
	}
	/**
	 * @return the denominator
	 */
	public BigInteger getDenominator() {
		return denominator;
	}	
	
	/**
	 * @param numerator the numerator to set
	 */
	public void setNumerator(BigInteger numerator) {
		this.numerator = numerator;
	}

	/**
	 * @param denominator the denominator to set
	 */
	public void setDenominator(BigInteger denominator) {
		this.denominator = denominator;
	}
	/**
	 * floatValue of the current Rational
	 * @return floatValue
	 */
	public float floatValue(){
		return (this.numerator.floatValue()/denominator.floatValue());
	}
	/**
	 * doubleValue of the current Rational
	 * @return doubleValue
	 */
	public double doubleValue(){
		return (this.numerator.doubleValue()/denominator.doubleValue());
	}
	/**
	 * shorten our string with the great common divisor
	 */
	public void shorten(){
		BigInteger g= this.numerator.gcd(denominator);
		this.numerator=this.numerator.divide(g);
		this.denominator=this.denominator.divide(g);
	}
	/**
	 * toString representation
	 */
	public String toString() {
		Rational r=this.copy();
		StringBuffer ret=new StringBuffer();
		r.normalize();
		r.shorten();
		if(r.numerator.compareTo(BigInteger.ZERO)<0){
			ret.append('-');
			r.negate();
		}
		if(r.denominator.compareTo(BigInteger.ONE)==0)
			ret.append(r.numerator.toString());
		else{
			BigInteger[] f=r.numerator.divideAndRemainder(r.denominator);
			if(f[0].compareTo(BigInteger.ZERO)>0){
				ret.append(f[0].toString()).append(' ').append(f[1].toString());
			}
			else
				ret.append(r.numerator.toString());
			ret.append('/').append(r.denominator.toString());
			
		}
		return ret.toString();
	}

	/**
	 * converts a long into a new Rational
	 * @param n numerator
	 * @return new Rational
	 */
	public static Rational valueOf(long n) {
		return Rational.valueOf(n, 1L);
	}

	/**
	 * converts two long into a new Rational
	 * @param n numerator
	 * @param d denominator
	 * @return new Rational
	 */
	public static Rational valueOf(long n, long d) {
		return Rational.valueOf(BigInteger.valueOf(n), BigInteger.valueOf(d));
	}

	/**
	 * converts two BigInteger into a new Rational
	 * @param n numerator
	 * @param d denominator
	 * @return new Rational
	 */
	public static Rational valueOf(BigInteger n, BigInteger d) {
		return new Rational(n,d);
	}

	// main

	

	// A test driver for the Rational class
	// To run this test, do "java Rational" at the command line
	public static void main(String[] args) {
		/* Get actual class name to be printed on */
		Logger logger = LogManager.getLogger(Rational.class);
		
		logger.entry();
		Rational A = new Rational(25893,51647);
		Rational B = new Rational(-46008L,51647);
		Rational C = new Rational(62750931,51808256L);

		logger.info(A);
		logger.info(B);
		logger.info(C);

		Rational D = B.mult(C);
		logger.info(D.getNumerator());
		logger.info(D.getDenominator());
		logger.info(D);

		A.sub(D);
		logger.error(A);
		logger.error(B);
		logger.error(C);
		logger.error(D);
		logger.exit();
	}
}