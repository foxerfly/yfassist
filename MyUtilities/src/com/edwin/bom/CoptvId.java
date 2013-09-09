package com.edwin.bom;
// Generated Sep 9, 2013 11:12:54 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * CoptvId generated by hbm2java
 */
public class CoptvId  implements java.io.Serializable {


     private String tv001;
     private String tv002;
     private String tv003;
     private BigDecimal tv004;

    public CoptvId() {
    }

    public CoptvId(String tv001, String tv002, String tv003, BigDecimal tv004) {
       this.tv001 = tv001;
       this.tv002 = tv002;
       this.tv003 = tv003;
       this.tv004 = tv004;
    }
   
    public String getTv001() {
        return this.tv001;
    }
    
    public void setTv001(String tv001) {
        this.tv001 = tv001;
    }
    public String getTv002() {
        return this.tv002;
    }
    
    public void setTv002(String tv002) {
        this.tv002 = tv002;
    }
    public String getTv003() {
        return this.tv003;
    }
    
    public void setTv003(String tv003) {
        this.tv003 = tv003;
    }
    public BigDecimal getTv004() {
        return this.tv004;
    }
    
    public void setTv004(BigDecimal tv004) {
        this.tv004 = tv004;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CoptvId) ) return false;
		 CoptvId castOther = ( CoptvId ) other; 
         
		 return ( (this.getTv001()==castOther.getTv001()) || ( this.getTv001()!=null && castOther.getTv001()!=null && this.getTv001().equals(castOther.getTv001()) ) )
 && ( (this.getTv002()==castOther.getTv002()) || ( this.getTv002()!=null && castOther.getTv002()!=null && this.getTv002().equals(castOther.getTv002()) ) )
 && ( (this.getTv003()==castOther.getTv003()) || ( this.getTv003()!=null && castOther.getTv003()!=null && this.getTv003().equals(castOther.getTv003()) ) )
 && ( (this.getTv004()==castOther.getTv004()) || ( this.getTv004()!=null && castOther.getTv004()!=null && this.getTv004().equals(castOther.getTv004()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTv001() == null ? 0 : this.getTv001().hashCode() );
         result = 37 * result + ( getTv002() == null ? 0 : this.getTv002().hashCode() );
         result = 37 * result + ( getTv003() == null ? 0 : this.getTv003().hashCode() );
         result = 37 * result + ( getTv004() == null ? 0 : this.getTv004().hashCode() );
         return result;
   }   


}


