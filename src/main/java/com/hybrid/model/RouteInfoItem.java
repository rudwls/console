package com.hybrid.model;

public class RouteInfoItem {
	private String busRouteId;
	private String busRouteNm;
	private String edStationNm;
	private String firstBusTm;
	private String firstLowTm;
	private String lastBusTm;
	private boolean lastBusYn;
	private String lastLowTm;
	private float length;
	private int routeType;
	private String stStationNm;
	private int term;

	public String getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(String busRouteId) {
		this.busRouteId = busRouteId;
	}

	public String getBusRouteNm() {
		return busRouteNm;
	}

	public void setBusRouteNm(String busRouteNm) {
		this.busRouteNm = busRouteNm;
	}

	public String getEdStationNm() {
		return edStationNm;
	}

	public void setEdStationNm(String edStationNm) {
		this.edStationNm = edStationNm;
	}

	public String getFirstBusTm() {
		return firstBusTm;
	}

	public void setFirstBusTm(String firstBusTm) {
		this.firstBusTm = firstBusTm;
	}

	public String getFirstLowTm() {
		return firstLowTm;
	}

	public void setFirstLowTm(String firstLowTm) {
		this.firstLowTm = firstLowTm;
	}

	public String getLastBusTm() {
		return lastBusTm;
	}

	public void setLastBusTm(String lastBusTm) {
		this.lastBusTm = lastBusTm;
	}

	public boolean isLastBusYn() {
		return lastBusYn;
	}

	public void setLastBusYn(boolean lastBusYn) {
		this.lastBusYn = lastBusYn;
	}

	public String getLastLowTm() {
		return lastLowTm;
	}

	public void setLastLowTm(String lastLowTm) {
		this.lastLowTm = lastLowTm;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public int getRouteType() {
		return routeType;
	}

	public void setRouteType(int routeType) {
		this.routeType = routeType;
	}

	public String getStStationNm() {
		return stStationNm;
	}

	public void setStStationNm(String stStationNm) {
		this.stStationNm = stStationNm;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}
