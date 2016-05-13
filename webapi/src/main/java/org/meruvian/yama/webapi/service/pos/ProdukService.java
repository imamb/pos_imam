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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tugas.pos.Produk;
import tugas.pos.Pembelian;

@Path("/api/produk")
@Produces(MediaType.APPLICATION_JSON) 
public interface ProdukService {
	@GET
	@Path("/{id}")
	Produk getProdukById(@PathParam("id") long id);
	
	@GET
	@Path("/{id}")
	Produk getProdukByNama(@PathParam("nama") @DefaultValue("") String nama);
	
	@GET
	List<Produk> findProdukByNama(@QueryParam("nama") @DefaultValue("") String nama);
	
	@POST
	Produk saveProduk(Produk produk);
	
	@PUT
	@Path("/{id}")
	Produk updateProduk(@PathParam("id") long id, Produk produk);
	
	@DELETE
	@Path("/{id}")
	void deleteProduk(@PathParam("id") long id);
	
	/*
	@GET
	@Path("/{id}/pembelians")
	Page<Pembelian> findPembelianByProduk(@PathParam("id") long id, Pageable pageable);
	
	@PUT
	@Path("/{id}/pembelians/{pembelianId}")
	boolean addPembelianToProduk(@PathParam("id") long id, @PathParam("pembelianId") long pembelianId);
	
	@DELETE
	@Path("/{id}/pembelians/{pembelianId}")
	boolean removePembelianFromProduk(@PathParam("id") long id, @PathParam("pembelianId") long pembelianId);
	*/
}
