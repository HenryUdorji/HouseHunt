# HouseHunt

HouseHunt is a modern real estate application built with Jetpack Compose and Supabase, designed to help users find their perfect home. The app features a sleek, user-friendly interface that makes browsing and searching for properties effortless.

## Tech Stack

- **UI Framework**: Jetpack Compose
- **Backend**: Supabase
- **Architecture**: MVVM (Model-View-ViewModel)
- **Language**: Kotlin

## Features

- Property listings with detailed information
- Advanced search and filtering options
- Real-time updates using Supabase's real-time capabilities
- Saved searches and favorite properties
- In-app messaging for property inquiries
- Virtual property tours

## Setup

### Prerequisites
- Android Studio Arctic Fox or newer
- JDK 11 or higher
- Android SDK 21 or higher

### Configuration

1. Clone the repository:
```bash
git clone https://github.com/yourusername/househunt.git
```

2. Add your Supabase credentials to `local.properties`:
```properties
SUPABASE_URL=your_supabase_url
SUPABASE_KEY=your_supabase_anon_key
```

3. Sync project with Gradle files

4. Run the app on an emulator or physical device

## Architecture

HouseHunt follows clean architecture principles and is organized into the following modules:

- **app**: Main application module
- **core**: Common utilities and extensions
- **data**: Repository implementations and data sources
- **domain**: Business logic and use cases
- **ui**: Compose UI components and screens

## Dependencies

- Jetpack Compose for UI
- Supabase Android Client
- Kotlin Coroutines
- Dagger Hilt for dependency injection
- Coil for image loading
- Material Design 3 components

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Design Attribution

The UI design for HouseHunt is based on the ["Real Estate App UI Kit"](https://www.figma.com/design/uR0Aty9r2SAIeOcNwYmMo3/Real-Estate-App-UI-Kit-(Community)?node-id=2-1753&t=jwsovVtMSyfPUJR7-0) by [Designer Name] available on Figma Community. We have adapted and implemented this design for Android using Jetpack Compose while maintaining the original design's aesthetic and user experience principles.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Your Name - [@henry_ifechukwu](https://twitter.com/henry_ifechukwu)

Project Link: [https://github.com/yourusername/househunt](https://github.com/yourusername/househunt)