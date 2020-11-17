<template>
  <v-app>
    <v-app-bar app color="primary" dark elevation="0">
      <v-spacer></v-spacer>
      <v-btn @click="toggleTheme" color="primary" class="mr-2">Change Color</v-btn>
      <v-icon>mdi-account</v-icon>
    </v-app-bar>
    <v-navigation-drawer
      v-model="sidebarMenu"
      app
      floating
      permanent
      expand-on-hover
    >
      <v-list dense color="primary" dark>
        <v-list-item>
          <v-list-item-action>
            <v-icon>mdi-movie</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              <h3 class="font-weight-thin">Movie Dashboard</h3>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <v-list-item class="px-2" @click="toggleMini = !toggleMini">
        <v-list-item-avatar>
          <v-icon>mdi-account-outline</v-icon>
        </v-list-item-avatar>
        <v-list-item-content class="text-truncate">
          Toan Admin
        </v-list-item-content>
      
      </v-list-item>
      <v-divider></v-divider>
      <v-list>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          :to="item.href"
        >
          <v-list-item-icon>
            <v-icon color="primary">{{ item.icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title class="primary--text">{{
              item.title
            }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
      <v-container class="px-4 py-0 fill-height" >
        <v-row class="fill-height">
            <v-container class="text-left">
                <router-view></router-view>
            </v-container>
        
        </v-row>
      </v-container>
    </v-main>
    <v-footer class="py-3">
      <span class="ml-auto overline">Toan &copy;2020</span>
    </v-footer>
  </v-app>
</template>
<script>
export default {
  data: () => ({
    sidebarMenu: true,
    toggleMini: false,
    items: [
      { title: "Home", href: "/admin", icon: "mdi-home-outline" },
      { title: "Category", href: "/category", icon: "mdi-format-list-bulleted" },
      { title: "Films", href: "/layoutFilm", icon: "mdi-film" },
    ],
  }),
  methods: {
    toggleTheme() {
      this.$vuetify.theme.dark = !this.$vuetify.theme.dark;
    },
  },
};
</script>
<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition-property: opacity;
  transition-duration: 0.25s;
}

.fade-enter-active {
  transition-delay: 0.25s;
}

.fade-enter,
.fade-leave-active {
  opacity: 0;
}

.theme--light.v-application ::-webkit-scrollbar {
  width: 13px;
}

.theme--light.v-application ::-webkit-scrollbar-track {
  background: #e6e6e6;
  border-left: 1px solid #dadada;
}

.theme--light.v-application ::-webkit-scrollbar-thumb {
  background: #b0b0b0;
  border: solid 3px #e6e6e6;
  border-radius: 7px;
}

.theme--light.v-application ::-webkit-scrollbar-thumb:hover {
  background: black;
}

.theme--dark.v-application ::-webkit-scrollbar {
  width: 13px;
}

.theme--dark.v-application ::-webkit-scrollbar-track {
  background: #202020;
  border-left: 1px solid #2c2c2c;
}

.theme--dark.v-application ::-webkit-scrollbar-thumb {
  background: #3e3e3e;
  border: solid 3px #202020;
  border-radius: 7px;
}

.theme--dark.v-application ::-webkit-scrollbar-thumb:hover {
  background: white;
}
</style>