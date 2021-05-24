package edu.mak.course.controller.rest;

import edu.mak.course.dao.model.Contract;
import edu.mak.course.service.ContractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Tag(name = "Contract", description = "Contract REST API")
@RestController
@RequestMapping("api/contract")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContractController {

    private final ContractService service;

    @Operation(summary = "Add a new contract", description = "Create contract object")
    @PostMapping("/create")
    public Contract create(@RequestBody Contract contract) {
        return service.create(contract);
    }

    @Operation(summary = "Get information about all contracts")
    @RequestMapping("/get/all")
    public List<Contract> getContracts() {
        return service.getAll();
    }

    @Operation(summary = "Get contract by ID", description = "Return a single contract")
    @GetMapping("get/{id}")
    public Optional<Contract> getById(@Parameter(name = "id", description = "ID of contract to get", required = true)
                                      @PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete contract by ID", description = "Delete a single contract")
    @DeleteMapping("delete/{id}")
    public Contract deleteById(@Parameter(name = "id", description = "ID of contract to delete", required = true)
                               @PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Update contract information", description = "Update contract object")
    @PutMapping("/update")
    public Contract update(@RequestBody Contract contract) {
        return service.update(contract);
    }
}
