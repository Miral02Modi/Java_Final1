package com.bridgelabz.util;
class Stock
{
  private  int id;	
  private String name;
  private int price;
  private int numShare;
	
  int getId()
  {
     return id;	
  }	
   void setId(int id)
  {
     this.id=id;	
  }		
  String getName()
  {
     return name;
  }
  int getnumShare()
  {
     return numShare;
  }
  int getPrice()
  {
      return price;
  } 
  void setName(String name)
  {
      this.name = name;
  }   
  void setPrice(int price)
  {
      this.price = price;
  }
  void setnumShare(int numShare)
  {
      this.numShare = numShare;
  }
    	  
}	
