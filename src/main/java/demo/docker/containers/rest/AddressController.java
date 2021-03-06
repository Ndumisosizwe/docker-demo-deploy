package demo.docker.containers.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.docker.containers.domain.Address;
import demo.docker.containers.repository.AddressRepository;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAllCustomerNames() {
        return new ResponseEntity<>(this.addressRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody @Valid Address address) {
        return new ResponseEntity<>(this.addressRepository.save(address), HttpStatus.OK);
    }

    @GetMapping(value = "/{id1}/equals/{id2}")
    @ResponseStatus(code = HttpStatus.OK)
    public boolean isAddressesEqual(@PathVariable Integer id1, @PathVariable Integer id2) {
        Optional<Address> ad1Optional = this.addressRepository.findById(new Long(id1));
        Optional<Address> ad2Optional = this.addressRepository.findById(new Long(id2));
        if (ad1Optional.isPresent() && ad2Optional.isPresent()) return ad1Optional.get().equals(ad2Optional.get());
        return false;
    }


}
