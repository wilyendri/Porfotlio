package com.wilyendri.portfolio.resume;

import org.springframework.web.bind.annotation.*;
import com.wilyendri.portfolio.resume.ServiceBook.NewBookRequest;

import java.util.List;

@RestController // adding to previous explanation it also
@RequestMapping("api/v1/books") //this indicates the path for get mapping (instead of adding the path to GetMapping)
public class HomeRestController {

    private final ServiceBook serviceBook;

    public HomeRestController(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    @GetMapping
    public List<Book> getBook(){
        return serviceBook.getBook();
    }


    @PostMapping
    public void addBook(@RequestBody NewBookRequest customerRequest){
        serviceBook.addBook(customerRequest);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        serviceBook.deleteBook(id);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable(name = "customerId") Integer id,
            @RequestBody NewBookRequest customerRequest
    ){
        serviceBook.updateBook(id, customerRequest);
    }
}
