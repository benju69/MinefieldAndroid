package com.minefield;

import java.util.ArrayList;
import java.util.HashMap;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

//import android.app.Activity;
import android.content.Intent;
//import android.graphics.Typeface;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//import android.widget.TextView;
import android.view.View;

public class displayLiens extends SherlockActivity {
	private ListView maListViewPerso;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.liens);
		
		BitmapDrawable bg = (BitmapDrawable) getResources().getDrawable(
				R.drawable.bgbar3);
		bg.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
		getSupportActionBar().setBackgroundDrawable(bg);
		
		getSupportActionBar().setLogo(R.drawable.redstone);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setTitle(R.string.liens_title);
	

		// Récupération de la listview créée dans le fichier main.xml
		maListViewPerso = (ListView) findViewById(R.id.listLiens);

		// Création de la ArrayList qui nous permettra de remplir la listView
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

		// On déclare la HashMap qui contiendra les informations pour un item
		HashMap<String, String> map;

		// Création d'une HashMap pour insérer les informations du premier item
		// de notre listView
		map = new HashMap<String, String>();
		// on insère un élément titre que l'on récupérera dans le textView titre
		// créé dans le fichier affichageitem.xml
		map.put("titre", "Minecraft.net");
		// on insère un élément description que l'on récupérera dans le textView
		// description créé dans le fichier affichageitem.xml
		map.put("description", "Site officiel du jeu");
		// on insère la référence à l'image (converti en String car normalement
		// c'est un int) que l'on récupérera dans l'imageView créé dans le
		// fichier affichageitem.xml
		map.put("img", String.valueOf(R.drawable.paper));
		// enfin on ajoute cette hashMap dans la arrayList
		map.put("url", "http://www.minecraft.net");
		listItem.add(map);

		// On refait la manip plusieurs fois avec des données différentes pour
		// former les items de notre ListView

		map = new HashMap<String, String>();
		map.put("titre", "Forums de Minecraft");
		map.put("description", "Forum officiel du jeu");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.minecraftforum.net/index.php");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Wiki de minecraft");
		map.put("description",
				"Wiki officiel du jeu (en anglais et en français)");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.minecraftwiki.net/wiki/Minecraft_Wiki");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Recettes de Minecraft");
		map.put("description", "Tous les crafts de Minecraft en français");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://fr.minecraftwiki.net/wiki/Artisanat");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Twitter de Notch");
		map.put("description", "Tous les tweets du Dieu N en personne :D");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://twitter.com/#!/notch");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Blog de Notch");
		map.put("description", "The word of notch");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://notch.tumblr.com/");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Facebook officiel de Minecraft");
		map.put("description", "La communauté sur le réseau facebook");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.facebook.com/minecraft");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Minecraft sur votre Android");
		map.put("description", "Le jeu sur mobile");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url",
				"https://market.android.com/details?id=com.mojang.minecraftpe");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "WTCraft");
		map.put("description",
				"Le premier site d'info sur Minecraft en français !");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.wtcraft.com/");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Minecraft.fr");
		map.put("description", "Communauté française minecraft");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://minecraft.fr/");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Voter pour le serveur sur MCserv");
		map.put("description", "Supporter Minefield sur mcserv.com !");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.mcserv.org/vote.php?id=1");
		listItem.add(map);
		
		map = new HashMap<String, String>();
		map.put("titre", "Minetoys");
		map.put("description", "Crafter votre personnage minecraft en jouet !");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.minetoys.com/");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "FantaBobShow");
		map.put("description", "Le site de cube le plus show !");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.fantabobshow.com/");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Wondercraft");
		map.put("description", "The minecraft comic !");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://wondercraft.net/");
		listItem.add(map);
		
		map = new HashMap<String, String>();
		map.put("titre", "Chaine Youtube de Minefield");
		map.put("description", "Des vidéos cubiques !");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.youtube.com/user/MinefieldFr/");
		listItem.add(map);
		
		map = new HashMap<String, String>();
		map.put("titre", "Chaine Youtube de Tyroine");
		map.put("description", "Le reporter de Minefield !");
		map.put("img", String.valueOf(R.drawable.paper));
		map.put("url", "http://www.youtube.com/user/ReporterDeMinefield");
		listItem.add(map);
		
		// Création d'un SimpleAdapter qui se chargera de mettre les items
		// présents dans notre list (listItem) dans la vue affichageitem
		SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(),
				listItem, R.layout.affichageitem, new String[] { "img",
						"titre", "description" }, new int[] { R.id.img,
						R.id.titre, R.id.description });

		// On attribue à notre listView l'adapter que l'on vient de créer
		maListViewPerso.setAdapter((ListAdapter) mSchedule);

		// Enfin on met un écouteur d'évènement sur notre listView
		maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
			@Override
			@SuppressWarnings("unchecked")
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				// on récupère la HashMap contenant les infos de notre item
				// (titre, description, img)
				HashMap<String, String> map = (HashMap<String, String>) maListViewPerso
						.getItemAtPosition(position);
				
				String url = map.get("url");

				Intent i = new Intent(Intent.ACTION_VIEW);
				Uri u = Uri.parse(url);
				i.setData(u);
				startActivity(i);
			}
		});

	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home) {
			this.finish();
			return false;
		}
		return false;
	}
	
	protected void onDestroy() {
		super.onDestroy();
	}

	protected void onPause() {
		super.onPause();
	}

	protected void onRestart() {
		super.onRestart();
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onStart() {
		super.onStart();
	}

	protected void onStop() {
		super.onStop();
	}
}