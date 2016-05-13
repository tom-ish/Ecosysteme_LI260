package fr.upmc.environnement;

public enum CaseType {
	//factory 
	VILLE_WATER_INONDEE(MapType.VILLE, 40000, "tsunami.png"), //
	GROTTE_WATER_INONDEE(40000, "tsunami.png"), //
	VILLE_CROUTE(MapType.VILLE, 30000, "croute.png"), //
	VILLE_CROUTE_H(MapType.VILLE, 10000, "croute_h.png"), //
	VILLE_CROUTE_V(MapType.VILLE, 20000, "croute_v.png"), //
	VILLE_CROUTE_LAVE_H(MapType.VILLE, 80000, "croute_lave_h.png"), //
	VILLE_CROUTE_LAVE_V(MapType.VILLE, 90000, "croute_v.png"), //
	VILLE_BURNINGTREE(MapType.VILLE, 60000, "burningtree.png",true), //
	VILLE_CENDRE(MapType.VILLE, 70000, "cendre.png"), //
	VILLE_SOL_MONTAGNE2(MapType.VILLE, 100000, "sol_montagne2.png"), //
	

	
	
	// VILLE
	VILLE_WATER(MapType.VILLE, 0, "eauNiv4.png"), //
	VILLE_WATER_PLAGE(MapType.VILLE, 30, "water_plage.png"), //
	VILLE_WATER_PLAGE_COTE(MapType.VILLE, 31, "water_plage_cote.png"), //
	VILLE_WATER_COIN(MapType.VILLE, 32, "water_plage_coin.png"), //
	VILLE_WATER_PLAGE_COIN2(MapType.VILLE, 33, "water_plage_coin2.png"), //
	VILLE_HERBE(MapType.VILLE, 1, "herbe.png"), //
	VILLE_HERBE_PLAGE(MapType.VILLE, 20, "herbe_plage.png"), //
	VILLE_HERBE_PLAGE3(MapType.VILLE, 21, "herbe_plage3.png"), //
	VILLE_HERBE_PLAGE_coin(MapType.VILLE, 22, "herbe_plage_coin.png"), //
	VILLE_HERBE_PLAGE4(MapType.VILLE, 23, "herbe_plage4.png"), //
	VILLE_HERBE_PLAGE5(MapType.VILLE, 24, "herbe_plage5.png"), //

	VILLE_BIGTREE3(MapType.VILLE, 2, "bigtree3.png", true), 
	VILLE_GRAINE(MapType.VILLE, 29, "graine.png"),

	VILLE_PLAGE(MapType.VILLE, 3, "plage.png"), //
	VILLE_SOL_MONTAGNE(MapType.VILLE, 4, "sol_montagne.png"), //
	VILLE_COTE_MONTAGNE(MapType.VILLE, 5, "cote_montagne.png",true), //
	VILLE_COTE_DROIT_MONTAGNE(MapType.VILLE, 6, "cote_droit_montagne.png",true), //
	VILLE_COIN_MONTAGNE(MapType.VILLE, 7, "coin_montagne.png", true), //

	VILLE_CAVE_HOLE(MapType.VILLE, 8, "caveHole.png", true), //
	VILLE_CAVE_CLIMB(MapType.VILLE, 80, "cave_climb.png"), //
	VILLE_GROTTE1(MapType.VILLE, 81, "grotte1.png",true), //
	VILLE_GROTTE2(MapType.VILLE, 82, "grotte2.png",true), //
	VILLE_GROTTE3(MapType.VILLE, 83, "grotte3.png",true), //
	VILLE_GROTTE4(MapType.VILLE, 84, "grotte4.png",true), //
	VILLE_LAVE(MapType.VILLE, 50000, "lave.png",true), //
	VILLE_GROTTE6(MapType.VILLE, 86, "grotte6.png",true), //
	VILLE_GROTTE7(MapType.VILLE, 87, "grotte7.png",true), //
	VILLE_GROTTE8(MapType.VILLE, 88, "grotte8.png",true), //
	VILLE_GROTTE9(MapType.VILLE, 89, "grotte9.png",true), //


	VILLE_CRATERE1(MapType.VILLE, 91, "cratere1.png", true), 
	VILLE_CRATERE2(MapType.VILLE, 92, "cratere2.png", true), 
	VILLE_CRATERE3(MapType.VILLE, 93, "cratere3.png", true), 
	VILLE_CRATERE4(MapType.VILLE, 94, "cratere4.png", true),


	// GROTTE
	
	GROTTE_TREE(3, "tree.png"), //
	GROTTE_GRASS(1, "herbe.png"), //
	GROTTE_BIG_TREE(2, "bigtree.png"), //
	GROTTE_CAVE(4, "grotte.png"), //
	GROTTE_SAND(5, "sand.png"), //
	GROTTE_PAROI_GAUCHE(6, "paroiGauche.png", true), //
	GROTTE_PAROI_DROITE(7, "paroiDroite.png", true), //
	GROTTE_PAROI_HAUTE(8, "paroiHaute.png", true), //
	GROTTE_COIN_GAUCHE(9, "coinGauche.png", true), //
	GROTTE_CREUX_GAUCHE(10, "creuxGauche.png", true), //
	GROTTE_CREUX_DROIT(11, "creuxDroit.png", true), //
	GROTTE_COIN_DROIT(12, "coinDroit.png", true), //
	GROTTE_PAROI_BASSE(13, "paroiBasse.png", true), //
	GROTTE_COIN_BAS_DROIT(14, "coinBasDroit.png", true), //
	GROTTE_EAUNIV4(17, "eauNiv4.png"), //
	GROTTE_EAUNIV3(18, "eauNiv3.png"), //
	GROTTE_EAUNIV2(19, "eauNiv2.png"), //
	GROTTE_CREUXEAUNIV3G(20, "creuxEauNiv3G.png"), //
	GROTTE_CREUXEAUNIV3D(21, "creuxEauNiv3D.png"), //
	GROTTE_CREUXEAUNIV2G(22, "creuxEauNiv2G.png"), //
	GROTTE_CREUXEAUNIV2D(23, "creuxEauNiv2D.png"), //
	GROTTE_PAROIEAUD(24, "paroiEauD.png", true), //
	GROTTE_PAROIEAUG(25, "paroiEauG.png", true), //
	GROTTE_EAUNIV45(26, "eauNiv45.png"), //
	GROTTE_COIN_EAU(27, "coinEau.png"), //
	GROTTE_COIN_EAUD(28, "coinEauD.png"), //
	GROTTE_COIN_SAND_DROIT(29, "coinSandDroit.png"), //
	GROTTE_COIN_GROTTEG(30, "coinGrotteG.png"), //
	GROTTE_ENTREE(31, "entreeGrotte.png", true), //
	GROTTE_CLIMB(33, "climb.png"), //
	GROTTE_PAROI_DROITE_GROTTE(34, "paroiDroiteGrotte.png", true); //

	private MapType mapType;
	private int identifiant;
	private String image;
	private boolean isObstacle;

	private CaseType(int identifiant, String image) {
		this(MapType.GROTTE, identifiant, image, false);
	}

	private CaseType(int identifiant, String image, boolean isObstacle) {
		this(MapType.GROTTE, identifiant, image, isObstacle);
	}

	private CaseType(MapType mapType, int identifiant, String image) {
		this(mapType, identifiant, image, false);
	}

	private CaseType(MapType mapType, int identifiant, String image, boolean isObstacle) {
		this.mapType = mapType;
		this.identifiant = identifiant;
		this.image = image;
		this.isObstacle = isObstacle;
	}

	public MapType getMapType() {
		return mapType;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public String getImage() {
		return "src/images/" + image;
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public static CaseType getCaseTypeById(int identifiant, MapType mapType) {
		for (CaseType type : values()) {
			if (type.getIdentifiant() == identifiant
					&& type.getMapType() == mapType) {
				return type;
			}
		}
		return null;
	}

	public static boolean isObstacle(int identifiant, MapType mapType) {
		for (CaseType type : values()) {
			if (type.getIdentifiant() == identifiant && type.getMapType() == mapType) {
				return type.isObstacle();
			}
		}
		return false;
	}
	
	public boolean isEau(){
		return (this == CaseType.VILLE_WATER 
				|| this == CaseType.VILLE_WATER_INONDEE 
				|| this == CaseType.GROTTE_WATER_INONDEE 
				|| this == CaseType.GROTTE_EAUNIV2
				|| this == CaseType.GROTTE_EAUNIV3
				|| this == CaseType.GROTTE_EAUNIV4
				|| this == CaseType.GROTTE_EAUNIV45);
	}

	public static boolean isInondable(int identifiant, MapType mapType) {
		CaseType casetype = getCaseTypeById(identifiant, mapType);
		if (mapType == MapType.VILLE) {
			switch (casetype) {
			case VILLE_COIN_MONTAGNE:
			case VILLE_COTE_DROIT_MONTAGNE:
			case VILLE_CAVE_CLIMB:
			case VILLE_SOL_MONTAGNE:
			case VILLE_COTE_MONTAGNE:
			case VILLE_WATER:
			case VILLE_WATER_INONDEE:
			case VILLE_CAVE_HOLE:
			case VILLE_BIGTREE3:
			case VILLE_LAVE:
				return false;
			default:
				return true;

			}
		}
		if (mapType == MapType.GROTTE) {
//			switch (casetype) {
//			case GROTTE_SAND:
//			case GROTTE_CREUXEAUNIV2D:
//			case GROTTE_EAUNIV2:
//			case GROTTE_CREUXEAUNIV2G:
//			case GROTTE_CREUXEAUNIV3D:
//			case GROTTE_CREUXEAUNIV3G:
//			case GROTTE_EAUNIV45:
//				return true;
//			default:
				return true;

//			}
		}
		return false;
	}
}
