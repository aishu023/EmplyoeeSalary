

	
	class SolidProduct extends Product {
	    private int Weight;
	    private int Volume;
	    public SolidProduct(int weight, int volume) {
	        super(0, 3);
	        Weight = weight;
	        Volume = volume;
	    }
	    public int CalculateSpace() {
	        return Weight * Volume * Factor;
	    }
	}

	class LiquidProduct extends Product {
	    private int Liter;
	    public LiquidProduct(int liter) {
	        super(0, 2);
	        Liter = liter;
	    }
	    public int CalculateSpace() {
	        return Liter * Factor;
	    }
	}

	class JewelProduct extends Product {
	    private int Count;
	    private int RequiredBox;
	    public JewelProduct(int count, int requiredBox) {
	        super(0, 1);
	        Count = count;
	        RequiredBox = requiredBox;
	    }
	    public int CalculateSpace() {
	        return Count * Factor + RequiredBox * Factor;
	    }
	}

	class TransportUnit implements ITransportUnit {
	    private List<Product> products = new ArrayList<Product>();
	    public void AddProduct(Product product) {
	        products.add(product);
	    }
	    public int GetTotalSpace() {
	        int totalSpace = 0;
	        for (Product item : products) {
	            totalSpace += item.CalculateSpace();
	        }
	        return totalSpace;
	    }
	}

