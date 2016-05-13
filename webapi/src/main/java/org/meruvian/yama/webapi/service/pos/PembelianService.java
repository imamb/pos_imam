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

import tugas.pos.Pembelian;
import tugas.pos.Produk;

@Path("/api/pembelian")
@Produces(MediaType.APPLICATION_JSON) 
public interface PembelianService {
	@GET
	@Path("/{id}")
	Pembelian getPembelianById(@PathParam("id") long id);
	
	@GET
	@Path("/{id}")
	Pembelian getPembelianByNomor(@PathParam("nomor") @DefaultValue("") String nomor);
	
	@GET
	List<Pembelian> findPembelianByNomor(@QueryParam("nomor") @DefaultValue("") String nomor);
	
	@POST
	Pembelian savePembelian(Pembelian pembelian);
	
	@PUT
	@Path("/{id}")
	Pembelian updatePembelian(@PathParam("id") long id, Pembelian pembelian);
	
	@DELETE
	@Path("/{id}")
	void deletePembelian(@PathParam("id") long id);
	
	@GET
	@Path("/{id}/produks")
	Page<Produk> findProdukByPembelian(@PathParam("id") long id, Pageable pageable);
	
	@PUT
	@Path("/{id}/produks/{produkId}")
	boolean addProdukToPembelian(@PathParam("id") long id, @PathParam("produkId") long produkId);
	
	@DELETE
	@Path("/{id}/produks/{produkId}")
	boolean removeProdukFromPembelian(@PathParam("id") long id, @PathParam("produkId") long produkId);

}
