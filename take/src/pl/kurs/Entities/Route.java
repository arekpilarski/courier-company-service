package pl.kurs.Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Route implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@XmlAttribute
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int routeId;
	private String startCity;
	private String destinationCity;
	private String startDate;
	private String finishDate;


	@ManyToOne(cascade = CascadeType.ALL)
	private Courier courier;
	
	@OneToMany(mappedBy = "route",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY)
	@XmlTransient
	List<Package> packagesToDeliver = new ArrayList<Package>();
	
	
	public List<Package> getPackagesToDeliver() {
		return packagesToDeliver;
	}

	public void setPackagesToDeliver(List<Package> packagesToDeliver) {
		this.packagesToDeliver = packagesToDeliver;
	}

	public void addPackage(Package pack) {
		packagesToDeliver.add(pack);
		pack.setRoute(this);
	}
	
	public void removePackage (Package pack) {
		packagesToDeliver.remove(pack);
		pack.setRoute(null);
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	
	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Courier getCourier() {
		return courier;
	}
	
	public void setCourier(Courier courier) {
		if(sameAsFormer(courier)) return;
		Courier oldCourier = this.courier;
		this.courier = courier;
		if(oldCourier != null)
			oldCourier.removeRoute(this);
		if(courier != null)
			courier.addRoute(this);
	}
	
	public boolean sameAsFormer(Courier newCourier) {
		if(this.courier == newCourier) return true;
		if(this.courier == null || newCourier == null) return false;
		return this.courier.equalss(newCourier);
	}
}
