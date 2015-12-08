TP4 - Plug-in
DELASSUS Alexandre
DUFLOS Nicolas

Pour les lancer les tests :

	- Ouvrir Eclipse
	- Selectionner le menu FILE -> Import
	- General / Existing project into Workspace puis 'Next'
	- Selectionner le dossier contenant le projet puis 'Finish'
	- Dans le Package Explorer, cliquer droit sur le dossier test
	- Run as -> JUnit Test

Les fichiers .project et .classpath ont été laissé pour permettre
à Eclipse d'inclure JUnit automatiquement.


Sample :

	Cette fonction nous permet de gerer l'ajout et le retrait des plugins par le timer.
	On regarde par le filtre la nouvelle liste de plugins qu'il y a dans le dossier.
	Puis on regarde les plugins a ajouter:

	Pour chaque s dans la nouvelle liste:
	Si il n'est pas dans l'ancienne liste de plugin alors on declenche l'ajout.

	Enfin on regarde les plugins a enlever:

	Pour chaque s dans l'ancienne liste:
	Si il n'est pas dans la nouvelle liste de plugin alors on declenche le retrait.

	Finalement on remplace l'ancienne liste par la nouvelle.
	
	public void actionPerformed(ActionEvent e) {
			
			String[] t = PluginFinder.this.dir.list(PluginFinder.this.filter);
			ArrayList<String> change = new ArrayList<String>(Arrays.asList(t));
			for(String s : change){
				if(!PluginFinder.this.files.contains(s)){
					PluginFinder.this.panel.addJMenuItem(s.substring(0,s.length() - 6));
				}
			}
			for(String s : PluginFinder.this.files){
				if(!change.contains(s)){
					PluginFinder.this.panel.removeJMenuItem(s.substring(0,s.length() - 6));
				}
			}
			
			PluginFinder.this.files = change;
			
		}


	Cette fonction nous permet d'instancer le plugin afin d'utiliser la fonction transform de celui ci:

	public void mouseClicked(MouseEvent arg0) {
			try{
				Class<?> classe = Class.forName("plugins." + s);
				Constructor<?> cons = classe.getConstructor();
				Plugin p = (Plugin) cons.newInstance();
				BigPanel.this.text.setText(p.transform(BigPanel.this.text.getText()));
				}
				catch(Exception e){
					System.out.println("Ca marche pas !");
				}
		}
