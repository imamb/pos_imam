package org.meruvian.yama.webapi.service.pos;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tugas.pos.Pembelian;
import tugas.pos.Sales;

@Path("/api/sales")
@Produces(MediaType.APPLICATION_JSON)
public interface SalesService {
	@GET
	@Path("/{id}")
	Sales getSalesById(@PathParam("id") long id);
	
	@GET
	@Path("/{id}")
	Sales getSalesByNama(@PathParam("nama") @DefaultValue("") String nama);
	
	@GET
	List<Sales> findSalesByNama(@PathParam("nama") @DefaultValue("") String nama);
	
	@POST
	Sales saveSales(Sales sales);
	
	@PUT
	@Path("/{id}")
	Sales updateSales(@PathParam("id") long id,Sales sales);
	
	@DELETE
	@Path("/{id}")
	void deleteSales(@PathParam("id") long id);
	
	@GET
	@Path("/{id}/pembelians")
	Page<Pembelian> findPembelianBySales(@PathParam("id") long id, Pageable pageable);
	
	@PUT
	@Path("/{id}/pembelians/{pembelianId}")
	boolean addPembelianToSales(@PathParam("id") long id, @PathParam("pembelianId") long pembelianId);
	
	@DELETE
	@Path("/{id}/pembelians/{pembelianId}")
	boolean removePembelianFromSales(@PathParam("id") long id, @PathParam("pembelianId") long pembelianId);
	
}
