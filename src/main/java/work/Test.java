package work;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author karl xie
 * Created on 2020-03-25 19:11
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("o94v755q4ykkuvV144RKywLn9g9s",
                "o94v750Qf4X_y8fVnJ13o-Stwct4",
                "o94v757QJ0_0iFE1kTiWurFqUTYo",
                "o94v75wpeCZzJQ_KAr9qTEcAgcJs",
                "o94v757D8IkUMndIRkK8wyxG4NLg",
                "o94v759oo2iVrtRWfhR_xiTLV3gk",
                "o94v757wVV98Fq_5WmddeZdXA9Bk",
                "o94v75w3AZOysXccAiNw2MLLTL84",
                "o94v756sxrtJa95UtkzQ1nte4cOo",
                "o94v754mLepz6zv25Dk53BHzZiIo",
                "o94v7523PeetgFEkpCJlvcwntsB4",
                "o94v75x2OH23trUtYrQB1FsIbEl8",
                "o94v7590ICwhrlTdqx_Dq1uQjydI",
                "o94v753CyX9-4awbeD2LvdFJkRiI",
                "o94v758IUc_t9-kcBbntpK9zhz64",
                "o94v754yU6Ks5yRJOD24NnMQtLJk",
                "o94v758jbhJEAFl766zRN4MCIBDg",
                "o94v755iMxQ3rNJbgGwsbE1PMEcY",
                "o94v754ZRFRJHq1rUC2jR1CmHrDI",
                "o94v75wDl0PUtv5N6LED0JBrG5CU",
                "o94v75zIQCe1vmB0DT5gycXIOnCI",
                "o94v75zJyrziue-YimhIhXDnFz_Q",
                "o94v754-dkVMVfLbL-9Nf1ESGZ6M",
                "o94v751SHJDEx85X3HTx3CFGenWs",
                "o94v756z_igDgRFaCcLdHHPy3y9c",
                "o94v7521fek1A04VTkmyiJHEQ0ew",
                "o94v757-Gj2hbflPlxfD6ZPtjlrQ",
                "o94v754HCIocVPoj7X_BHzJ4Ri1g",
                "o94v75zptTDbpoc5ENJfhhy2Zjoc",
                "o94v756addl81NroFhyF0HD-Y2ko",
                "o94v75433TeCC-4lP9RSAAOY-Hso",
                "o94v7594jYKKMBd_nrGnGHrk2Zz0",
                "o94v7535V-YSJMpCW00VMQQFcjiE",
                "o94v752aE3PNfV-zs3OgjaRqJSeE",
                "o94v752BvH9ToBMrnWSellBYKl9s",
                "o94v754gHVX0JjQt22q-HVSdMpKQ",
                "o94v758cmV2lLNM1wfiit4hKkiO0",
                "o94v75zIhbergUR4PIXn3TqApUtI",
                "o94v75_kCGbMk_nEJzNL_Po6NBCo",
                "o94v75xOrROycSeGxcX3KrJ4tVVY");
        ArrayList<String> list1 = Lists.newArrayList("o94v755q4ykkuvV144RKywLn9g9s",
                "o94v750Qf4X_y8fVnJ13o-Stwct4",
                "o94v757QJ0_0iFE1kTiWurFqUTYo",
                "o94v75wpeCZzJQ_KAr9qTEcAgcJs",
                "o94v757D8IkUMndIRkK8wyxG4NLg",
                "o94v759oo2iVrtRWfhR_xiTLV3gk",
                "o94v757wVV98Fq_5WmddeZdXA9Bk",
                "o94v75w3AZOysXccAiNw2MLLTL84",
                "o94v756sxrtJa95UtkzQ1nte4cOo",
                "o94v754mLepz6zv25Dk53BHzZiIo",
                "o94v7523PeetgFEkpCJlvcwntsB4",
                "o94v75x2OH23trUtYrQB1FsIbEl8",
                "o94v7590ICwhrlTdqx_Dq1uQjydI",
                "o94v753CyX9-4awbeD2LvdFJkRiI",
                "o94v758IUc_t9-kcBbntpK9zhz64",
                "o94v754yU6Ks5yRJOD24NnMQtLJk",
                "o94v758jbhJEAFl766zRN4MCIBDg",
                "o94v755iMxQ3rNJbgGwsbE1PMEcY",
                "o94v754ZRFRJHq1rUC2jR1CmHrDI",
                "o94v75wDl0PUtv5N6LED0JBrG5CU",
                "o94v75wKQNxtmqB8hYyQyyHRK9Ok",
                "o94v75zIQCe1vmB0DT5gycXIOnCI",
                "o94v75zJyrziue-YimhIhXDnFz_Q",
                "o94v754-dkVMVfLbL-9Nf1ESGZ6M",
                "o94v751SHJDEx85X3HTx3CFGenWs",
                "o94v756z_igDgRFaCcLdHHPy3y9c",
                "o94v7521fek1A04VTkmyiJHEQ0ew",
                "o94v757-Gj2hbflPlxfD6ZPtjlrQ",
                "o94v754HCIocVPoj7X_BHzJ4Ri1g",
                "o94v75zptTDbpoc5ENJfhhy2Zjoc",
                "o94v756addl81NroFhyF0HD-Y2ko",
                "o94v75433TeCC-4lP9RSAAOY-Hso",
                "o94v7594jYKKMBd_nrGnGHrk2Zz0",
                "o94v7535V-YSJMpCW00VMQQFcjiE",
                "o94v752aE3PNfV-zs3OgjaRqJSeE",
                "o94v752BvH9ToBMrnWSellBYKl9s",
                "o94v754gHVX0JjQt22q-HVSdMpKQ",
                "o94v758cmV2lLNM1wfiit4hKkiO0",
                "o94v75zIhbergUR4PIXn3TqApUtI",
                "o94v75_kCGbMk_nEJzNL_Po6NBCo",
                "o94v75xOrROycSeGxcX3KrJ4tVVY");
     list1.stream().filter(item->{
       return !list.contains(item);
     }).collect(Collectors.toList()).forEach(System.out::println);

    }
}