package com.tcs.ilp.bean;

public class AllSales
{
    private String productCode;

    private String qty;

    private String productName;

    private String revenue;

    public String getProductCode ()
    {
        return productCode;
    }

    public void setProductCode (String productCode)
    {
        this.productCode = productCode;
    }

    public String getQty ()
    {
        return qty;
    }

    public void setQty (String qty)
    {
        this.qty = qty;
    }

    public String getProductName ()
    {
        return productName;
    }

    public void setProductName (String productName)
    {
        this.productName = productName;
    }

    public String getRevenue ()
    {
        return revenue;
    }

    public void setRevenue (String revenue)
    {
        this.revenue = revenue;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [productCode = "+productCode+", qty = "+qty+", productName = "+productName+", revenue = "+revenue+"]";
    }
}
