package test;

public class MockCalculator extends com.maths.Calculator{

	public MockCalculator(int WIDTH, int HEIGHT) {
		super(WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double f(double x){
		return x*x;
	}
}
