import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GalleryComponent } from './gallery/gallery.component';
import { HomeComponent } from './home/home.component';

const APP_ROUTES: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'prendas', component: GalleryComponent },
    { path: '**', pathMatch:'full', redirectTo : 'home' },
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);