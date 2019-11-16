package api.player.server;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ServerPlayerBaseSorter {

   private Map explicitInferiors;
   private Map explicitSuperiors;
   private Map directInferiorsMap;
   private Map allInferiors;
   private List withoutSuperiors;
   private final List list;
   private final Map allBaseSuperiors;
   private final Map allBaseInferiors;
   private final String methodName;
   private static final Set Empty = new HashSet();


   public ServerPlayerBaseSorter(List var1, Map var2, Map var3, String var4) {
      this.list = var1;
      this.allBaseSuperiors = var2;
      this.allBaseInferiors = var3;
      this.methodName = var4;
   }

   public void Sort() {
      if(this.list.size() > 1) {
         if(this.explicitInferiors != null) {
            this.explicitInferiors.clear();
         }

         if(this.explicitSuperiors != null) {
            this.explicitSuperiors.clear();
         }

         if(this.directInferiorsMap != null) {
            this.directInferiorsMap.clear();
         }

         if(this.allInferiors != null) {
            this.allInferiors.clear();
         }

         int var1;
         for(var1 = 0; var1 < this.list.size(); ++var1) {
            String var2 = (String)this.list.get(var1);
            String[] var3 = (String[])this.allBaseInferiors.get(var2);
            boolean var4 = var3 != null && var3.length > 0;
            String[] var5 = (String[])this.allBaseSuperiors.get(var2);
            boolean var6 = var5 != null && var5.length > 0;
            if((var4 || var6) && this.directInferiorsMap == null) {
               this.directInferiorsMap = new Hashtable();
            }

            if(var4) {
               this.explicitInferiors = build(var2, this.explicitInferiors, this.directInferiorsMap, (Map)null, var3);
            }

            if(var6) {
               this.explicitSuperiors = build(var2, this.explicitSuperiors, (Map)null, this.directInferiorsMap, var5);
            }
         }

         int var13;
         Set var21;
         if(this.directInferiorsMap != null) {
            for(var1 = 0; var1 < this.list.size() - 1; ++var1) {
               for(var13 = var1 + 1; var13 < this.list.size(); ++var13) {
                  String var14 = (String)this.list.get(var1);
                  String var16 = (String)this.list.get(var13);
                  Set var18 = null;
                  var21 = null;
                  if(this.explicitInferiors != null) {
                     var18 = (Set)this.explicitInferiors.get(var14);
                     var21 = (Set)this.explicitInferiors.get(var16);
                  }

                  Set var7 = null;
                  Set var8 = null;
                  if(this.explicitSuperiors != null) {
                     var7 = (Set)this.explicitSuperiors.get(var14);
                     var8 = (Set)this.explicitSuperiors.get(var16);
                  }

                  boolean var9 = var7 != null && var7.contains(var16);
                  boolean var10 = var18 != null && var18.contains(var16);
                  boolean var11 = var8 != null && var8.contains(var14);
                  boolean var12 = var21 != null && var21.contains(var14);
                  if(var9 && var11) {
                     throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method \'" + this.methodName + "\'. \'" + var14 + "\' wants to be inferior to \'" + var16 + "\' and \'" + var16 + "\' wants to be inferior to \'" + var14 + "\'");
                  }

                  if(var10 && var12) {
                     throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method \'" + this.methodName + "\'. \'" + var14 + "\' wants to be superior to \'" + var16 + "\' and \'" + var16 + "\' wants to be superior to \'" + var14 + "\'");
                  }

                  if(var9 && var10) {
                     throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method \'" + this.methodName + "\'. \'" + var14 + "\' wants to be superior and inferior to \'" + var16 + "\'");
                  }

                  if(var11 && var12) {
                     throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method \'" + this.methodName + "\'. \'" + var16 + "\' wants to be superior and inferior to \'" + var14 + "\'");
                  }
               }
            }

            if(this.allInferiors == null) {
               this.allInferiors = new Hashtable();
            }

            for(var1 = 0; var1 < this.list.size(); ++var1) {
               this.build((String)this.list.get(var1), (String)null);
            }
         }

         if(this.withoutSuperiors == null) {
            this.withoutSuperiors = new LinkedList();
         }

         var1 = 0;
         var13 = this.list.size();

         while(var13 > 1) {
            this.withoutSuperiors.clear();

            int var15;
            for(var15 = var1; var15 < var1 + var13; ++var15) {
               this.withoutSuperiors.add(this.list.get(var15));
            }

            if(this.allInferiors != null) {
               for(var15 = var1; var15 < var1 + var13; ++var15) {
                  Set var17 = (Set)this.allInferiors.get(this.list.get(var15));
                  if(var17 != null) {
                     this.withoutSuperiors.removeAll(var17);
                  }
               }
            }

            boolean var19 = true;

            for(int var20 = var1; var20 < var1 + var13; ++var20) {
               String var22 = (String)this.list.get(var20);
               if(this.withoutSuperiors.contains(var22)) {
                  if(var19) {
                     var21 = null;
                     if(this.allInferiors != null) {
                        var21 = (Set)this.allInferiors.get(var22);
                     }

                     if(var21 == null || var21.isEmpty()) {
                        this.withoutSuperiors.remove(var22);
                        --var13;
                        ++var1;
                        continue;
                     }
                  }

                  this.list.remove(var20--);
                  --var13;
               }

               var19 = false;
            }

            this.list.addAll(var1 + var13, this.withoutSuperiors);
         }

      }
   }

   private Set build(String var1, String var2) {
      Set var3 = (Set)this.allInferiors.get(var1);
      if(var3 == null) {
         var3 = this.build(var1, (Set)null, var2 != null?var2:var1);
         if(var3 == null) {
            var3 = Empty;
         }

         this.allInferiors.put(var1, var3);
      }

      return var3;
   }

   private Set build(String var1, Set var2, String var3) {
      Set var4 = (Set)this.directInferiorsMap.get(var1);
      if(var4 == null) {
         return (Set)var2;
      } else {
         if(var2 == null) {
            var2 = new HashSet();
         }

         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            if(var6 == var3) {
               throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method \'" + this.methodName + "\'. Circular superiosity found including \'" + var3 + "\'");
            }

            if(this.list.contains(var6)) {
               ((Set)var2).add(var6);
            }

            Set var7;
            try {
               var7 = this.build(var6, var3);
            } catch (UnsupportedOperationException var9) {
               throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method \'" + this.methodName + "\'. Circular superiosity found including \'" + var6 + "\'", var9);
            }

            if(var7 != Empty) {
               ((Set)var2).addAll(var7);
            }
         }

         return (Set)var2;
      }
   }

   private static Map build(String var0, Map var1, Map var2, Map var3, String[] var4) {
      if(var1 == null) {
         var1 = new Hashtable();
      }

      HashSet var5 = new HashSet();

      for(int var6 = 0; var6 < var4.length; ++var6) {
         if(var4[var6] != null) {
            var5.add(var4[var6]);
         }
      }

      if(var2 != null) {
         getOrCreateSet(var2, var0).addAll(var5);
      }

      if(var3 != null) {
         Iterator var7 = var5.iterator();

         while(var7.hasNext()) {
            getOrCreateSet(var3, (String)var7.next()).add(var0);
         }
      }

      ((Map)var1).put(var0, var5);
      return (Map)var1;
   }

   private static Set getOrCreateSet(Map var0, String var1) {
      Set var2 = (Set)var0.get(var1);
      if(var2 != null) {
         return var2;
      } else {
         HashSet var3 = new HashSet();
         var0.put(var1, var3);
         return var3;
      }
   }

}
