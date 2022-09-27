package com.example.b2synchronous.di;

import com.example.b2synchronous.DependencyInjectionActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * MyComponent -- real estate agent who knows both the buyer and seller
 */

@Singleton
@Component(modules = {SharedPrefModule.class}) //SharedPrefModule -- seller
public interface MyComponent {

    void inject(DependencyInjectionActivity activity); //DependencyInjectionActivity --- buyer


}