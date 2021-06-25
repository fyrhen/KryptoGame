import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moedas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moedas extends Actor
{
    public int proximoPasso = 2;
    public static final int TAXA_DE_ATUALIZACAO = 6;
    
    public void act() 
    {
        rodaMoeda();
        movimentaMoeda();
        sairCena();
    }    
    
    /*
     * Faz com que a moeda saia de cena
     */
    public void sairCena(){
        if (getX() <= 0){
            getWorld().removeObject(this);
        }
    }
    
    private void movimentaMoeda(){

        move(MyWorld.TAMANHO_DO_QUADRO * -1);

    }
    private void rodaMoeda(){
        setImage(new GreenfootImage("moedas/coin"+proximoPasso+".png"));

        if( possoAtualizar()){
            proximoPasso++;
        }

        if(proximoPasso > 6){
            proximoPasso = 1;
        }

    }
    private boolean possoAtualizar(){
        MyWorld myworld = (MyWorld) getWorld();
        return (myworld.cicloAtual() % TAXA_DE_ATUALIZACAO) == 0 ;
    }

}
