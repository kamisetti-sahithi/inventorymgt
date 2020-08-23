package com.dxctraining.inventorymgt.supplier.dto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class Data {
	private int id=-1;
	private boolean userLogin;
	
	public Data() {
		
	}
	
	public Data(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void saveLogin(int id){
        this.userLogin=true;
        this.id=id;
    }

    public void  clear(){
        id=-1;
        userLogin=false;
    }
	
	public boolean isUserLoggedin() {
		return userLogin;
	}
	


}
