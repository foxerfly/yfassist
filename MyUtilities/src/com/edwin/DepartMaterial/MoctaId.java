package com.edwin.DepartMaterial;
// Generated Jun 23, 2013 8:44:29 AM by Hibernate Tools 3.6.0



/**
 * MoctaId generated by hbm2java
 */
public class MoctaId  implements java.io.Serializable {


     private String ta001;
     private String ta002;

    public MoctaId() {
    }

    public MoctaId(String ta001, String ta002) {
       this.ta001 = ta001;
       this.ta002 = ta002;
    }
   
    public String getTa001() {
        return this.ta001;
    }
    
    public void setTa001(String ta001) {
        this.ta001 = ta001;
    }
    public String getTa002() {
        return this.ta002;
    }
    
    public void setTa002(String ta002) {
        this.ta002 = ta002;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MoctaId) ) return false;
		 MoctaId castOther = ( MoctaId ) other; 
         
		 return ( (this.getTa001()==castOther.getTa001()) || ( this.getTa001()!=null && castOther.getTa001()!=null && this.getTa001().equals(castOther.getTa001()) ) )
 && ( (this.getTa002()==castOther.getTa002()) || ( this.getTa002()!=null && castOther.getTa002()!=null && this.getTa002().equals(castOther.getTa002()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTa001() == null ? 0 : this.getTa001().hashCode() );
         result = 37 * result + ( getTa002() == null ? 0 : this.getTa002().hashCode() );
         return result;
   }   


}


