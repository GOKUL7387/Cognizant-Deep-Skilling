import java.util.*;

class Product implements Comparable<Product> 
{
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) 
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public Product() {}

    public int getProductId() 
    {
        return productId;
    }

    public String getProductName() 
    {
        return productName;
    }

    public String getCategory() 
    {
        return category;
    }

    @Override
    public int compareTo(Product other) 
    {
        return this.productName.compareTo(other.productName);
    }

    @Override
    public String toString() 
    {
        return "Product{ID=" + productId + ", Name=" + productName + ", Category=" + category + "}";
    }
}

class SearchManager 
{
    public static Product linearSearch(List<Product> products, String productName) 
    {
        for (Product product : products) 
        {
            if (product.getProductName().equals(productName)) 
            {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> products, String productName) 
    {
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            int comparison = products.get(mid).getProductName().compareTo(productName);

            if (comparison == 0) 
            {
                return products.get(mid);
            } 
            else if (comparison < 0) 
            {
                left = mid + 1;
            } 
            else 
            {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class EcommerceSearch 
{
    public static void main(String[] args) 
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "iPhone 14", "Electronics"));
        products.add(new Product(102, "MacBook Pro", "Electronics"));
        products.add(new Product(103, "Galaxy S22", "Electronics"));
        products.add(new Product(104, "Pixel 7", "Electronics"));

        System.out.println("\nLinear Search:");
        Product result1 = SearchManager.linearSearch(products, "MacBook Pro");
        System.out.println(result1);

        System.out.println("\nBinary Search:");
        products.sort(Comparator.comparing(Product::getProductName));
        Product result2 = SearchManager.binarySearch(products, "MacBook Pro");
        System.out.println(result2);
    }
}