package CV;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Lehamare on 16/04/15.
 */


@Controller
@RequestMapping("/resume")
public class XMLController {

    Liste maListe;

    public XMLController() {
        this.maListe = this.initialiseCVList();
    }

    public Liste initialiseCVList(){

        Liste liste = new Liste();
        ArrayList<Langue> Lg1 = new ArrayList<Langue>();
        Lg1.add(new Langue("Francais",2));

        liste.add(new Cv(1,"Arezki","EZZERRIFI AMRANI",Lg1));
        //*********************************************************************************
        ArrayList<Langue> Lg2 = new ArrayList<Langue>();
        Lg2.add(new Langue("Francais",2));
        Lg2.add(new Langue("Anglais",2));

        liste.add(new Cv(2,"Bellaid","Ouardoul",Lg2));
        //*********************************************************************************
        ArrayList<Langue> Lg3 = new ArrayList<Langue>();
        Lg3.add(new Langue("Francais",2));
        Lg3.add(new Langue("Espagnol",1));

        liste.add(new Cv(3,"Reda","JAI",Lg3));
        //*********************************************************************************
        return liste;
    }


    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody
    Cv getCVInXML(@PathVariable int id) {

        return this.maListe.getById(id);
    }



    @RequestMapping(value="", method = RequestMethod.GET)
    public @ResponseBody
    Liste getCVListInXML() {
        return this.maListe;
    }

    @RequestMapping(value="ajouter", method = RequestMethod.POST)
    public @ResponseBody void addCVWithPost(@RequestBody Cv cv) {

        this.maListe.add(cv);
    }
}
