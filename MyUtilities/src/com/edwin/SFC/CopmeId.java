package com.edwin.SFC;
// Generated Oct 26, 2013 9:03:44 AM by Hibernate Tools 3.6.0



/**
 * CopmeId generated by hbm2java
 */
public class CopmeId  implements java.io.Serializable {


     private String me001;
     private String me200;

    public CopmeId() {
    }

    public CopmeId(String me001, String me200) {
       this.me001 = me001;
       this.me200 = me200;
    }
   
    public String getMe001() {
        return this.me001;
    }
    
    public void setMe001(String me001) {
        this.me001 = me001;
    }
    public String getMe200() {
        return this.me200;
    }
    
    public void setMe200(String me200) {
        this.me200 = me200;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CopmeId) ) return false;
		 CopmeId castOther = ( CopmeId ) other; 
         
		 return ( (this.getMe001()==castOther.getMe001()) || ( this.getMe001()!=null && castOther.getMe001()!=null && this.getMe001().equals(castOther.getMe001()) ) )
 && ( (this.getMe200()==castOther.getMe200()) || ( this.getMe200()!=null && castOther.getMe200()!=null && this.getMe200().equals(castOther.getMe200()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMe001() == null ? 0 : this.getMe001().hashCode() );
         result = 37 * result + ( getMe200() == null ? 0 : this.getMe200().hashCode() );
         return result;
   }   


}

