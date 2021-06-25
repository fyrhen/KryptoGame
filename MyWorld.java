import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //Constantes da natureza do mundo
    public static final int LARGURA_CENARIO = 700; 
    public static final int ALTURA_CENARIO = 350; 
    public static final int QUANTIDADE_QUADROS = 139;
    public static final int TAMANHO_DO_QUADRO = 10;
    public static final int NIVEL_DO_SOLO = 309;
    public static final int FORCA_DA_GRAVIDADE = 5;
    public static final String NOME_ARQUIVO_IMAGEM = "cenarios/cenario_0_"; 
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png"; 

    private int quadroAtual = 1;
    private int cicloAtual = 0;
    private Player player;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);
        GreenfootImage cenarioInicial = new GreenfootImage("cenario1.png");
        setBackground(cenarioInicial);
        player = new Player();        
        addObject(player, 100, 258);
        //addObject(new LHorizontal(), 100, player.alturaDosPes() );
        //addObject(new LVertical(), 100, 303);
    }

    public int cicloAtual(){
        return cicloAtual;
    }

    private void contaCiclo(){
        cicloAtual++;
        if(cicloAtual > 1000){
            cicloAtual = 0;
        }

    }

    public void aplicarForcaDaGravidade(){
        if(player.alturaAtual() > 0){
            player.setLocation(player.getX(), player.getY() + FORCA_DA_GRAVIDADE);
        }
    }

    public void act(){
        projetor(proximaCena());
        aplicarForcaDaGravidade();  
        criadorDeMoedas();

        contaCiclo();

    }

    public void criadorDeMoedas(){

        if (cicloAtual() % 30 == 0){

            int y = Greenfoot.getRandomNumber(100) + 170;
            addObject(new Moedas(), 900, y);

        }   
    }

    private void projetor(GreenfootImage novaCena){
        setBackground(novaCena);

    }

    private GreenfootImage proximaCena(){
        GreenfootImage novaCena = filme();

        quadroAtual++;
        if(quadroAtual > QUANTIDADE_QUADROS){
            quadroAtual = 0;
        }
        return novaCena;
    }

    private GreenfootImage filme(){

        GreenfootImage novaCena  =  new GreenfootImage(LARGURA_CENARIO,ALTURA_CENARIO);
        int posicaoDoQuadro = 0;
        int quadro = quadroAtual;
        while(posicaoDoQuadro < LARGURA_CENARIO ){
            if(quadro > QUANTIDADE_QUADROS){
                quadro = 1;
            }
            novaCena.drawImage(imagemDoNovoQuadro(quadro), posicaoDoQuadro, 0);
            quadro++;
            posicaoDoQuadro += TAMANHO_DO_QUADRO;

        }
        return novaCena;
    }

    private GreenfootImage imagemDoNovoQuadro(int proximoQuadro){
        String nomeDoArquivo = NOME_ARQUIVO_IMAGEM + proximoQuadro + EXTENSAO_ARQUIVO_IMAGEM;
        GreenfootImage novoQuadro = new GreenfootImage(nomeDoArquivo );
        return novoQuadro;

    }
}

