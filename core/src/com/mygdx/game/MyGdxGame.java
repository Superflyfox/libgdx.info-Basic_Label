package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
	private Stage stage;


	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		int Help_Guides = 12;
		int row_height = Gdx.graphics.getWidth() / 12;
		int col_width = Gdx.graphics.getWidth() / 12;
		addBackgroundGuide(Help_Guides);

		Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		Label title = new Label("Centered title label",mySkin,"big-black");
		title.setSize(Gdx.graphics.getWidth(),row_height);
		title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
		title.setAlignment(Align.center);
		stage.addActor(title);

		Label label1 = new Label("This is a Label on  5 columns but WITHOUT wrap",mySkin,"black");
		label1.setSize(Gdx.graphics.getWidth()/Help_Guides,row_height);
		label1.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*4);
		stage.addActor(label1);

		Label label2 = new Label("This is a Label with a 5 columns width but WITH wrap",mySkin,"black");
		label2.setSize(Gdx.graphics.getWidth()/Help_Guides*5,row_height);
		label2.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*5);
		label2.setWrap(true);
		stage.addActor(label2);

		Label label3 = new Label("Font scaled down",mySkin,"black");
		label3.setSize(Gdx.graphics.getWidth()/Help_Guides*5,row_height);
		label3.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*6);
		label3.setFontScale((float)0.5);
		stage.addActor(label3);

		Label label4 = new Label("Modifying skin (color/background)",mySkin);
		label4.setSize(Gdx.graphics.getWidth()/Help_Guides*5,row_height);
		label4.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*7);
		label4.getStyle().fontColor = Color.BLUE;
		label4.getStyle().background = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("salmon.jpg"))));
		stage.addActor(label4);

	}

	public void addBackgroundGuide(int columns){
		Texture texture = new Texture(Gdx.files.internal("background.jpg"));
		texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

		TextureRegion textureRegion = new TextureRegion(texture);
		textureRegion.setRegion(0,0,texture.getWidth()*columns,texture.getWidth()*columns);
		Image background = new Image(textureRegion);
		background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
		background.setPosition(0,Gdx.graphics.getHeight()-background.getHeight());
		stage.addActor(background);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();

	}
}
