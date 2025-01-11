package org.scrum.restaurant.restservice;

import jakarta.transaction.Transactional;
import org.scrum.restaurant.management.Comenzi;
import org.scrum.restaurant.repo.ComenziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/service/comenzi")
@Transactional
public class ComenziRest {
    private static Logger logger = Logger.getLogger(ComenziRest.class.getName());

    @Autowired
    private ComenziRepository comenziRepository;

    @PostMapping("/create")
    @ResponseBody
    public Comenzi createComanda(@RequestBody Comenzi comenzi) {
        logger.info("Creating new order: " + comenzi);
        return comenziRepository.save(comenzi);
    }

    @GetMapping("/findByStatus/{status}")
    @ResponseBody
    public List<Comenzi> getComenziByStatus(@PathVariable("status") String status) {
        logger.info("Finding orders with status: " + status);
        return comenziRepository.findByStatus(status);
    }

    @GetMapping("/findByDateRange")
    @ResponseBody
    public List<Comenzi> getComenziByDateRange(@RequestParam("startDate") Date startDate,
                                               @RequestParam("endDate") Date endDate) {
        logger.info("Finding orders between dates: " + startDate + " and " + endDate);
        return comenziRepository.findByDataComenziiBetween(startDate, endDate);
    }

    @GetMapping("/findByTotalGreaterThan")
    @ResponseBody
    public List<Comenzi> getComenziByTotalGreaterThan(@RequestParam("total") Double total) {
        logger.info("Finding orders with total greater than: " + total);
        return comenziRepository.findByTotalComandaGreaterThanEqual(total);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Comenzi updateComanda(@PathVariable("id") Integer id, @RequestBody Comenzi comenzi) {
        logger.info("Updating order with id: " + id);
        comenzi.setIdComanda(id);
        return comenziRepository.save(comenzi);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteComanda(@PathVariable("id") Integer id) {
        logger.info("Deleting order with id: " + id);
        comenziRepository.deleteById(id);
    }
}
