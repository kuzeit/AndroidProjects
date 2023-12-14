package com.example.our_graduationproject.SERVER;

public class URLs {

    public static final String ROOT_URL = "http://192.168.43.116:8000/api/";
   //1|CbEsncO2zrYc21dA3JIxWnm9cC5XOadG0vqpUevD
//      4|aI7hq1Stcj5xhmPveogK4Kb9QMqIBmvYFqwXQ7y9
   public static final String GET_SCOPES = ROOT_URL + "app/config/scopes";
    public static final String CHAT = ROOT_URL + "app/chat/send_message";

    public static final String RATING = ROOT_URL + "app/order/customize/rating-designer";
    public static final String LIKE = ROOT_URL + "app/design/add_like";

    public static final String GET_SUGGEST_COLORS = ROOT_URL + "app/config/suggest_colors";
    public static final String GET_USER = ROOT_URL + "user";

    public static final String GET_SUGGEST_FONTS = ROOT_URL + "app/config/suggest_fonts";

    public static final String URL_REGISTER = ROOT_URL + "app/account/register";
    public static final String URL_LOGIN = ROOT_URL + "app/account/login";
    public static final String GET_COLORS = ROOT_URL + "app/config/colors";
    public static final String GET_PREFERENCES = ROOT_URL + "app/config/type_prefernces";
    public static final String GET_PREFERENCES_VALUE = ROOT_URL + "app/config/values_prefernce";

    public static final String POST_DESIGN_TYPE = ROOT_URL + "app/order/customize/types";
     public static final String POST_ORDER = ROOT_URL + "app/order/customize/orders";

    public static final String GET_DESIGN_TYPES = ROOT_URL + "app/config/types";
    public static final String GET_DESIGNERS = ROOT_URL + "app/config/designers";
    public static final String GET_DESIGNES = ROOT_URL + "app/design/designs";
    public static final String GET_Fonts = ROOT_URL + "app/app/config/fonts";
 public static final String GET_Detailes = ROOT_URL + "app/design/designs";
    public static final String GET_ORDERS =ROOT_URL+"app/order/get-orders";
    public static final String APLOUD_IMAGE =ROOT_URL+"app/order/customize/upload_image" ;

    public static final String APLOUD_FILE =ROOT_URL+"app/order/customize/upload_file" ;

    public static   String GET_CHAT(int  type) {
        return ROOT_URL+"app/chat/get_chat/"+type
                ;
    }

    public static   String GET_DETAILES(int  type) {
        return GET_Detailes  + "/"+type
                ;
    }



}
