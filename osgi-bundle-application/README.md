# osgi-bundle-application
An OSGI Sample application based on the Red Hat JBoss Fuse 6.x documentation - Sample OSGI Application: [Managing OSGI Dependencies manual](https://access.redhat.com/documentation/en-US/Red_Hat_JBoss_Fuse/6.0/html/Managing_OSGi_Dependencies/files/ImportExport-Sample.html)

This sample app implements the following design:

![OSGI Sample App](https://access.redhat.com/documentation/en-US/Red_Hat_JBoss_Fuse/6.1/html/Managing_OSGi_Dependencies/images/packages_02.gif)

NOTE: this sample project is based on the description of the Red Hat JBoss Fuse documentation. For more details please refer to the [Managing OSGI Dependencies section](https://access.redhat.com/documentation/en-US/Red_Hat_JBoss_Fuse/6.0/html/Managing_OSGi_Dependencies/files/front.html).
This implementation has two main differences from the original design proposed in Product's Documentaton: 1) I used some Brazilian Timezones and locations (Bahia and Sao Paulo instead of Paris and Boston); 2) I used the [Joda-Time API](http://www.joda.org/) for Date&Time.

This version of the project uses the JBoss Fuse Features deployment model. 
The Features Service is only available in `Fabric` mode.

Build the features project in order to install the feature JAR in our local maven repo. Thus JBoss Fuse can pickup the our feature artifact from maven local repo

```
cd features/
mvn clean install
```

Start the JBoss Fuse container

```
. $JBOSS_FUSE_HOME/bin/fuse
```

Create and initialize a new `fabric`

```
JBossFuse:karaf@root> fabric create --wait-for-provisioning
```

Now create a new child container to be used in our lab

```
JBossFuse:karaf@root> fabric:container-create-child --resolver localip root osgi-lab
```

In `fabric` mode the features are managed by `profiles`. So we have to create a new `profile` to provide our `feature`.

```
JBossFuse:karaf@root> fabric:profile-create --parents jboss-fuse-minimal labs-osgi
```

Once the profile was created we have to add our feature inside it

```
JBossFuse:karaf@root> fabric:profile-edit --repositories mvn:br.net.rafaeltuelho.osgi/osgi-bundle-application/1.0-SNAPSHOT/xml/features labs-osgi

JBossFuse:karaf@root> profile-edit --features osgi-hello-sanple/0.0.0 labs-osgi
```

Next we have to assign this profile to our child container (`osgi-lab`)

```
JBossFuse:karaf@root> container-change-profile osgi-lab labs-osgi
```

Now you can see the conatiner status

```
JBossFuse:karaf@root> fabric:container-list
[id]                           [version] [connected] [profiles]                                         [provision status]
root*                          1.0       true        fabric, fabric-ensemble-0000-1                     success
  osgi-lab                     1.0       true        labs-osgi                                          success

```

Connect to the conatiner `osgi-lab` and list the bundles installed

```
JBossFuse:admin@root> container-connect osgi-lab
JBossFuse:admin@osgi-lab> osgi:list

[ 140] [Active     ] [Created     ] [       ] [   60] hello-bahia Impl provider Bundle (0.0.1.SNAPSHOT)
[ 141] [Active     ] [            ] [       ] [   60] hello-bahia API Bundle (0.0.1.SNAPSHOT)
[ 142] [Active     ] [Created     ] [       ] [   60] hello-consumer Bundle (0.0.1.SNAPSHOT)
[ 143] [Active     ] [Created     ] [       ] [   60] hello-saopaulo API/Provider Bundle (0.0.1.SNAPSHOT)
[ 144] [Active     ] [            ] [       ] [   60] timeutil Library Bundle (0.0.2.SNAPSHOT)
[ 145] [Active     ] [            ] [       ] [   60] Joda-Time (2.7)
```

Restart the hello-consumer bundle to see the output messages

```
JBossFuse:admin@osgi-lab> osgi:restart 142
         >>> São Paulo says: E dae mano!!!  at 20/02/2015 13:13:74 BRST
         >>> Bahia says: Fala meu rei!!!  at 20/02/2015 12:13:78 BRT

```

