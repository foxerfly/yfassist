package com.edwin.authorize;
// Generated Jun 7, 2013 9:45:51 PM by Hibernate Tools 3.6.0

/**
 * AuthorizeDetail generated by hbm2java
 */
public class AuthorizeDetail implements java.io.Serializable {

    private String authorizeId;
    private String authorizeName;
    private String relatedModule;
    private String describe;

    public AuthorizeDetail() {
    }

    public AuthorizeDetail(String authorizeId) {
        this.authorizeId = authorizeId;
    }

    public AuthorizeDetail(String authorizeId, String authorizeName, String relatedModule, String describe) {
        this.authorizeId = authorizeId;
        this.authorizeName = authorizeName;
        this.relatedModule = relatedModule;
        this.describe = describe;
    }

    public String getAuthorizeId() {
        return this.authorizeId;
    }

    public void setAuthorizeId(String authorizeId) {
        this.authorizeId = authorizeId;
    }

    public String getAuthorizeName() {
        return this.authorizeName;
    }

    public void setAuthorizeName(String authorizeName) {
        this.authorizeName = authorizeName;
    }

    public String getRelatedModule() {
        return this.relatedModule;
    }

    public void setRelatedModule(String relatedModule) {
        this.relatedModule = relatedModule;
    }

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
