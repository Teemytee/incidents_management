package com.example.demo.controller;

import com.example.demo.model.Dep;
import com.example.demo.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepController {

    private final DepService depService;

    @Autowired
    public DepController(DepService depService) {
        this.depService = depService;
    }

    @PostMapping(value = "/deps")
    public ResponseEntity<?> create(@RequestBody Dep dep) {
        depService.create(dep);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/deps")
    public ResponseEntity<List<Dep>> read() {
        final List<Dep> deps = depService.readAll();

        return deps != null &&  !deps.isEmpty()
                ? new ResponseEntity<>(deps, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/deps/{name}")
    public ResponseEntity<Dep> read(@PathVariable(name = "name") String name) {
        final Dep dep = depService.read(name);

        return dep != null
                ? new ResponseEntity<>(dep, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/deps/{name}")
    public ResponseEntity<?> update(@PathVariable(name = "name") String name, @RequestBody Dep dep) {
        final boolean updated = depService.update(dep, name);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/deps/{name}")
    public ResponseEntity<?> delete(@PathVariable(name = "name") String name) {
        final boolean deleted = depService.delete(name);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
