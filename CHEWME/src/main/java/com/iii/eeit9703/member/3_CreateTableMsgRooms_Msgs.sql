��U S E   C M D B ;  
 G O  
  
  
 I F   E X I S T S   ( S E L E C T   n a m e   F R O M   s y s o b j e c t s  
                         W H E R E   t y p e = ' u '   A N D   n a m e   =   ' m s g s ' )              
 B E G I N  
 I F   ( O B J E C T _ I D ( ' m s g _ f o r e i g n _ k e y ' ,   ' F ' )   I S   N O T   N U L L )  
 B E G I N  
         A L T E R   T A B L E   m s g s   D R O P   C O N S T R A I N T   m s g _ f o r e i g n _ k e y    
 E N D  
 E N D  
 g o  
  
  
 I F   E X I S T S   ( S E L E C T   n a m e   F R O M   s y s o b j e c t s  
                         W H E R E   t y p e = ' u '   A N D   n a m e   =   ' m s g _ r o o m s ' )              
 B E G I N  
 D R O P   T A B L E   m s g _ r o o m s  
 E N D  
 g o  
  
 I F   E X I S T S   ( S E L E C T   n a m e   F R O M   s y s o b j e c t s  
                         W H E R E   t y p e = ' u '   A N D   n a m e   =   ' m s g s ' )              
 B E G I N  
 D R O P   T A B L E   m s g s  
 E N D  
 g o  
  
  
  
  
 C R E A T E   T A B L E   m s g _ r o o m s (  
 m s g R o o m I d         i n t   n o t   n u l l ,  
 m e m b e r I d           v a r c h a r ( 3 0 ) ,  
 C O N S T R A I N T   m s g _ r o o m s _ p r i m a r y _ k e y   P R I M A R Y   K E Y ( m s g r o o m I d ) ,  
 )  
 A L T E R   T A B L E   m s g _ r o o m s   A D D   C O N S T R A I N T   m s g _ r o o m s _ f o r e i g n _ k e y   F O R E I G N   K E Y   ( m e m b e r I d ) R E F E R E N C E S   m e m b e r s ( m e m b e r I d )    
  
 C R E A T E   T A B L E   m s g s (  
 m s g R o o m I d           i n t   n o t   n u l l ,  
 m s g N o                   i n t   n o t   n u l l ,  
 m e m b e r I d             v a r c h a r ( 3 0 ) ,  
 m s g                       t e x t ,  
 m s g T i m e               t i m e s t a m p ,  
 m s g S t a t u s           i n t ,  
 C O N S T R A I N T   m s g s _ p r i m a r y _ k e y   P R I M A R Y   K E Y ( m s g n o )  
 )  
  
 I F   E X I S T S   ( S E L E C T   n a m e   F R O M   s y s o b j e c t s  
                         W H E R E   t y p e = ' u '   A N D   n a m e   =   ' m s g _ r o o m s ' )              
 B E G I N  
 A L T E R   T A B L E   m s g s   A D D   C O N S T R A I N T   m s g _ f o r e i g n _ k e y   f o r e i g n   k e y   ( m s g r o o m I d ) R E F E R E N C E S   m s g _ r o o m s ( m s g r o o m I d )    
 E N D  
  
 s e l e c t   *   f r o m   m s g _ r o o m s  
 s e l e c t   *   f r o m   m s g s  
 g o 