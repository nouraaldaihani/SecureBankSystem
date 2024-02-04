package com.lecoded.secureBankSystem.Controller;
import com.lecoded.secureBankSystem.ob.Contant;
import com.lecoded.secureBankSystem.ob.CreateFarewellRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CodedController {

    List<Contant> allcontant = new ArrayList<>();
    @GetMapping("/sayHI")
    public String sayHi(){
        return "Welcome";
    }

    @GetMapping("/myName")
    public String myname(@RequestParam String name){
        return "Hello, " +name+ "!";
    }

@PostMapping("/farewell")
public String farewell(@RequestBody CreateFarewellRequest createFarewellRequest){

    return "GoodBye, "+ createFarewellRequest.getName();
}

@PostMapping("/addContact")
public String addContact(@RequestBody Contant contant){
        allcontant.add(contant);
    return "contang info:" + "name: "+ contant.getName()+" email: "+ contant.getEmail()+ " number: "+contant.getNumber();
}
@GetMapping("/getContactDetails")
public String getContactDetails(@RequestParam  String name,Contant details){
    if (name.equals(details.getName())){
        details.getName();
        details.getName();
        details.getNumber();
    }else {
        return "not found";
    }
    return name +"  number: "+ details.getNumber()+ "  email:  "+ details.getEmail() ;
}
}