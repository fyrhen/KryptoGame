import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int proximoPasso = 2;
    public static final int ALTURA_MAXIMA_PULO = 10;

    public boolean estaEmTerraFirme = true;
    public boolean estaEmPulo = false;
    public int alturaAtualDoPulo = 0;

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {       
        gerenciamentoDoMovimento();
        gerenciamentoDoPulo();
        cataMoeda();
    }
    public void cataMoeda(){
        Actor obj = getOneIntersectingObject(Moedas.class);
        if (obj != null){
            Greenfoot.playSound("sounds/coin1.wav");
            getWorld().removeObject(obj);
        }
        
    }
    
    /**
     * Gerenciar as instruções da movimento
     */
    private void gerenciamentoDoMovimento(){
        setImage(new GreenfootImage("player/correndo/rr_"+proximoPasso+".png"));
        proximoPasso++;
        if(proximoPasso > 20){
            proximoPasso = 1;
        } 
    }
    
    /**
    * Gerenciar as instruções do pulo
    */
    private void gerenciamentoDoPulo(){
        capturaInicioDoPulo();
        executaSubidaDoPulo();
        executaDescidaDoPulo();
        executaApiceDoPulo();
        executaPousoDoPulo();
    }
    
    private void capturaInicioDoPulo(){
        if(Greenfoot.isKeyDown("space") && estaEmTerraFirme){
            estaEmTerraFirme = false;
            estaEmPulo = true; 

        }
    }
    
    private void executaSubidaDoPulo(){
        if(alturaAtualDoPulo < ALTURA_MAXIMA_PULO && estaEmPulo ){
            alturaAtualDoPulo++;
            setLocation(getX(), getY() - MyWorld.FORCA_DA_GRAVIDADE * 2);

        }
    }

    private void executaApiceDoPulo(){
        if(alturaAtualDoPulo == ALTURA_MAXIMA_PULO ){
     
            estaEmPulo = false;

        }
    }
    
    private void executaDescidaDoPulo(){
        if(alturaAtualDoPulo > 0 && !estaEmPulo ){
            alturaAtualDoPulo--;
            
        }
    }
    
    private void executaPousoDoPulo(){
        if(alturaAtualDoPulo == 0 && !estaEmPulo ){
            estaEmTerraFirme = true;
            
        }
    }
    /**
     * Retorna o valor do limite inferior do personagem
     */
    public int alturaDosPes(){

        return getY() + getImage().getHeight()/2;

    }

    public int alturaAtual(){

        return (alturaDosPes() - MyWorld.NIVEL_DO_SOLO) * -1;

    }
}
