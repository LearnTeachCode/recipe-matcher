//
// Mudassar
//
//Ingredient Class
public class Ingredient
{
    private String iamount;
    private String idescription;
 
    //Constructor
    public Ingredient ()
    {
      this.iamount = null;
      this.idescription = null;
    }
    public String getAmount()
    {
        return iamount;
    }
    public void setAmount(String iamount)
    {
        this.iamount = iamount;
    }
    public String getiDescription()
    {
        return idescription;
    }
    public void setiDescription(String idescription)
    {
        this.idescription = idescription;
    }
}
 
//Main Class

public class TestIngredient
{
    public static void main(String[] args)
    {
 
        Ingredient new item1 = Ingredient();
        item1.setAmount("2");
        item1.setiDescription("Baking Powder")
        System.out.println("Ingredient :" + item1.getAmount())
        System.out.println("Ammount :" + item1.getiDescription() )
      
        Ingredient new item2 = Ingredient();
        item2.setAmount("3");
        item2.setiDescription("Sugar")
        System.out.println("Ingredient :" + item2.getAmount())
        System.out.println("Ammount :" + item2.getiDescription() )
      
        Ingredient new item3 = Ingredient();
        item3.setAmount("2");
        item3.setiDescription("Choclate")
        System.out.println("Ingredient :" + item3.getAmount())
        System.out.println("Ammount :" + item3.getiDescription() )
      
        Ingredient new item4 = Ingredient();
        item4.setAmount("4");
        item4.setiDescription("Cream")
        System.out.println("Ingredient :" + item4.getAmount())
        System.out.println("Ammount :" + item4.getiDescription() )
      
        Ingredient new item5 = Ingredient();
        item5.setAmount("2");
        item5.setiDescription("Peanuts")
        System.out.println("Ingredient :" + item5.getAmount())
        System.out.println("Ammount :" + item5.getiDescription() )
      
        Ingredient new item6 = Ingredient();
        item6.setAmount("1");
        item6.setiDescription("Butter")

        System.out.println("Ingredient :" + item6.getAmount())
        System.out.println("Ammount :" + item6.getiDescription() )
    }
}